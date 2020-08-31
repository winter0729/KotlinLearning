package com.github.winter0729.kotlinLearning

import kong.unirest.Unirest

fun btcPrice(): Any? {

    return Unirest.get("https://api.bithumb.com/public/ticker/BTC")
        .asJson()
        .body
        .getObject()
        .getJSONObject("data")
        .getString("opening_price")
}

fun ethPrice(): Any? {

    return Unirest.get("https://api.bithumb.com/public/ticker/ETH")
        .asJson()
        .body
        .getObject()
        .getJSONObject("data")
        .getString("opening_price")
}