package com.github.winter0729.kotlinLearning

import com.github.winter0729.kotlinLearning.game.*
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class MessageListener : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val user = event.author
        val guild = event.guild
        val tc = event.textChannel
        val msg = event.message
        val eb = EmbedBuilder()

//        if (user.isBot) return

        if (msg.contentRaw == "겨울이 안녕") {
            val name = event.member?.nickname
                ?: user.name
            tc.sendMessage("안녕! $name").queue()

        }

        if (msg.contentRaw == "어웨이크") {
            tc.sendMessage("-메-").queue()
        }

        if (msg.contentRaw == "겨울이 코인가격") {

            eb.setTitle("오늘 코인 가격", null)
            eb.setColor(0xffff00)
            eb.setDescription("한강일까? 떡상일까?")

            eb.addField("BTC", "${btcPrice()}원", true)
            eb.addField("ETC", "${ethPrice()}원", true)

            tc.sendMessage(eb.build()).queue()
        }

        if (msg.contentRaw == "겨울이 블랙잭") {
            gameStart()
            playerId = user.id

            eb.setTitle("블랙잭 시작")
            eb.setColor(0x000000)

            eb.addField("봇", bot.toString(), true)
            eb.addField("플레이어", player.toString(), true)

            tc.sendMessage(eb.build()).queue()

            gameDebug()
        }

        if (msg.contentRaw == "힛") {
            if (status == 1) {
                if (playerId == user.id) {

//                    player += random(1, 12)
                    player += random()

                    bot = botTmp
                    botTmp += random()
                    if (botTmp <= 21) {
                        bot = botTmp
                    }

                    eb.setTitle("블랙잭")
                    eb.setColor(0x000000)

                    eb.addField("봇", bot.toString(), true)
                    eb.addField("플레이어", player.toString(), true)

                    tc.sendMessage(eb.build()).queue()
                    tc.sendMessage("흐음~ 잠시만기다려주세요~!").queue()


                    gameDebug()
                }
            }
        }

        if (msg.contentRaw == "흐음~ 잠시만기다려주세요~!") {

            if (player > 21) {
                eb.setTitle("블랙잭")
                eb.setDescription("봇 승리")

                eb.addField("봇", bot.toString(), true)
                eb.addField("블레이어", player.toString(), true)

                tc.sendMessage(eb.build()).queue()

                gameDebug()
                gameEnd()
            }

            if (player == 21) {
                eb.setTitle("블랙잭")
                eb.setDescription("플레이어 승리")

                eb.addField("봇", bot.toString(), true)
                eb.addField("플레이어", player.toString(), true)

                tc.sendMessage(eb.build()).queue()
                gameDebug()
                gameEnd()
            }

            if (bot == 21){
                eb.setTitle("블랙잭")
                eb.setDescription("봇 승리")

                eb.addField("봇", bot.toString(), true)
                eb.addField("블레이어", player.toString(), true)

                tc.sendMessage(eb.build()).queue()
                gameDebug()
                gameEnd()
            }

            if (bot > 21){
                eb.setTitle("블랙잭")
                eb.setDescription("플레이어 승리")

                eb.addField("봇", bot.toString(), true)
                eb.addField("플레이어", player.toString(), true)

                tc.sendMessage(eb.build()).queue()
                gameDebug()
                gameEnd()
            }
        }

        if (msg.contentRaw == "스탠드") {
            if (status == 1) {
                if (playerId == user.id) {

//                    player += random(1, 12)

                    bot = botTmp
                    botTmp += random()
                    if (botTmp <= 21) {
                        bot = botTmp
                    }

                    eb.setTitle("블랙잭")
                    eb.setColor(0x000000)

                    eb.addField("봇", bot.toString(), true)
                    eb.addField("플레이어", player.toString(), true)

                    tc.sendMessage(eb.build()).queue()
                    tc.sendMessage("흐음~ 잠시만기다려주세요~!").queue()


                    gameDebug()
                }
            }
        }
    }
}