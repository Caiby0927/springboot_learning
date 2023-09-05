package com.cai.tacocloud.controller;

import com.cai.tacocloud.entity.Ingredient;
import com.cai.tacocloud.entity.Ingredient.Type;
import com.cai.tacocloud.entity.Taco;
import com.cai.tacocloud.entity.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
/*
  在类中自动生成一个SLF4J Logger静态属性，相当于在类中显式声明：
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger (DesignTacoController.class);
 */
@Controller
/*
  将该类识别为控制器，并将其作为组件扫描的候选者
 */
@RequestMapping("/design")
/*
  指定该控制器所处理的请求类型，这里规定了DesignTacoController会处理路径以"/design"开头的请求
 */
@SessionAttributes("tacoOrder")
/*
  表明在这个类中稍后放到模型里面的TacoOrder对象应该在会话中一直保持
 */
public class DesignTacoController {

    @ModelAttribute
    /*
      放到Model属性中的数据将会复制到Servlet Request的属性中
     */
    public void addIngredientsToModel(Model model) {
        /*
          Model 对象负责在控制器和展现数据的视图之间传递数据
         */
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla",Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    /*
      创建新的对象放置到模型中
     */
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    /*
      @GetMapping结合类级别的@RequestMapping，指明当接收到对"/design"的HTTP GET请求时，Spring MVC将会调用showDesignForm()来处理
      请求
     */
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    /*
      @PostMapping与@RequestMapping协作，指定processTaco方法要处理针对"/design"的POST请求
      TacoOrder参数上所使用的@ModelAttribute表明它应该使用模型中的TacoOrder对象
      @Valid注解会告诉SpringMVC要对提交的Taco对象进行校验，而校验时机是绑定完表单之后、调用processDesign()之前
     */
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) {
//            判断是否有校验错误
            return "design";
        }

        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        /*
          redirect: 表明这是一个重定向视图，在processTaco完成后，用户的浏览器会重定向到相对路径"/order/current"
         */
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }


}
