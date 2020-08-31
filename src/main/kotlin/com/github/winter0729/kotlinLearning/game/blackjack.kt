package com.github.winter0729.kotlinLearning.game

import java.util.*

var status = 0

var player = 1
var bot = 1
var botTmp = 1
var playerId: String = ""

val random = Random()
fun random(): Int {
    return random.nextInt(12) + 1
}

fun gameStart() {
    status = 1
    player = 1
    bot = 1
}

fun gameEnd() {
    status = 0
    player = 1
    bot = 1
}

fun gameDebug() {
    print("status $status\nplayer $player\nbot $bot\n")
}