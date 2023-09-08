package com.cai.tacocloud.data;

import com.cai.tacocloud.entity.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder order);
}
