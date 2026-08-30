package com.github.jaunikapauni.jetbrainsdiscordplugin.discord
import com.google.gson.JsonObject
import com.jagrosh.discordipc.IPCClient
import com.jagrosh.discordipc.IPCListener
import com.jagrosh.discordipc.entities.ActivityType
import com.jagrosh.discordipc.entities.Packet
import com.jagrosh.discordipc.entities.RichPresence
import com.jagrosh.discordipc.entities.User
import com.jagrosh.discordipc.entities.pipe.PipeStatus

object DiscordPresenceService {

    private val CLIENT_ID = "1543667843231383593"
    private val client = IPCClient(CLIENT_ID.toLong())

    fun connect(projectName: String, ideName: String){
        try {
            client.setListener(object : IPCListener {
                override fun onPacketSent(client: IPCClient?, packet: Packet?) {
                }

                override fun onPacketReceived(client: IPCClient?, packet: Packet?) {
                }

                override fun onActivityJoin(client: IPCClient?, secret: String?) {
                }

                override fun onActivitySpectate(client: IPCClient?, secret: String?) {
                }

                override fun onActivityJoinRequest(client: IPCClient?, secret: String?, user: User?) {
                }

                override fun onReady(client: IPCClient?) {
                    val presence = RichPresence.Builder().setActivityType(ActivityType.Playing).setDetails("Working on $projectName").build()
                    client?.sendRichPresence(presence)
                }

                override fun onClose(client: IPCClient?, json: JsonObject?) {
                }

                override fun onDisconnect(client: IPCClient?, t: Throwable?) {
                }
            })
            client.connect()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun disconnect(){
        if(client.status == PipeStatus.CONNECTED){
            client.close()
        }
    }
}