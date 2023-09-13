package com.cai.tacocloud.data;

import com.cai.tacocloud.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

//    TacoOrder save(TacoOrder order);
}
