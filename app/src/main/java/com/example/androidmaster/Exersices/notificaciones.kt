package com.example.androidmaster.Exersices

fun main() {
    val morningNotification = 51
    val eveningNotification = 131

    printNotification(morningNotification)
    printNotification(eveningNotification)

}

fun printNotification(numberOfMessages: Int) {
    if (numberOfMessages > 100) {
        println("hay +99 notificaciones")
    } else {
        println("hay $numberOfMessages notificaciones")
    }
}