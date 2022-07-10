fun main() {
    var currentWater = 400
    var currentMilk = 540
    var currentBeans = 120
    var currentCups = 9
    var currentMoney = 550
    var machineOn = true

    fun enoughWaterFor(coffee: Int): Boolean {
        val noWater = "\nSorry, not enough water!\n"
        return when (coffee) {
            1 -> {
                if (currentWater - 250 >= 0) true else {
                    println(noWater)
                    false
                }
            }
            2 -> {
                if (currentWater - 350 >= 0) true else {
                    println(noWater)
                    false
                }
            }
            3 -> {
                if (currentWater - 200 >= 0) true else {
                    println(noWater)
                    false
                }
            }
            else -> {
                print("error water")
                false
            }
        }
    }

    fun enoughMilkFor(coffee: Int): Boolean {
        val noMilk = "\nSorry, not enough milk!\n"
        return when (coffee) {
            1 -> true
            2 -> {
                if (currentMilk - 75 >= 0) true else {
                    println(noMilk)
                    false
                }
            }
            3 -> {
                if (currentMilk - 100 >= 0) true else {
                    println(noMilk)
                    false
                }
            }
            else -> {
                print("error milk")
                false
            }
        }
    }

    fun enoughBeansFor(coffee: Int): Boolean {
        val noBeans = "\nSorry, not enough beans!\n"
        return when (coffee) {
            1 -> {
                if (currentBeans - 16 >= 0) true else {
                    println(noBeans)
                    false
                }
            }
            2 -> {
                if (currentBeans - 20 >= 0) true else {
                    println(noBeans)
                    false
                }
            }
            3 -> {
                if (currentBeans - 12 >= 0) true else {
                    println(noBeans)
                    false
                }
            }
            else -> {
                print("error beans")
                false
            }
        }
    }

    fun enoughCupsFor(coffee: Int): Boolean {
        val noCups = "\nSorry, not enough cups!\n"
        return when (coffee) {
            1, 2, 3 -> {
                if (currentCups - 1 >= 0) true else {
                    println(noCups)
                    false
                }
            }
            else -> {
                print("error cups")
                false
            }
        }
    }
    fun enoughResources(coffee: Int): Boolean {
        return enoughWaterFor(coffee) && enoughCupsFor(coffee) && enoughMilkFor(coffee) && enoughBeansFor(coffee)
    }


    while (machineOn) {
        print("Write action (buy, fill, take, remaining, exit): ")
        when (readln()) {
            "buy" -> {
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
                when (readln()) {
                    "1" -> {
                        if (enoughResources(1)) {
                            println("I have enough resources, making you a coffee!\n")
                            currentWater -= 250
                            currentBeans -= 16
                            currentCups -= 1
                            currentMoney += 4
                        }
                    }
                    "2" -> {
                        if (enoughCupsFor(2) && enoughBeansFor(2) && enoughWaterFor(2) && enoughMilkFor(2)) {
                            println("I have enough resources, making you a coffee!\n")
                            currentWater -= 350
                            currentMilk -= 75
                            currentBeans -= 20
                            currentCups -= 1
                            currentMoney += 7
                        }
                    }
                    "3" -> {
                        if (enoughCupsFor(3) && enoughBeansFor(3) && enoughWaterFor(3) && enoughMilkFor(2)) {
                            println("I have enough resources, making you a coffee!\n")
                            currentWater -= 200
                            currentMilk -= 100
                            currentBeans -= 12
                            currentCups -= 1
                            currentMoney += 6
                        }
                    }
                    "back" -> {
                        println()
                    }
                    else -> "error"
                }
            }
            "fill" -> {
                print("Write how many ml of water do you want to add: ")
                currentWater += readln().toInt()
                print("Write how many ml of milk do you want to add: ")
                currentMilk += readln().toInt()
                print("Write how many grams of coffee beans do you want to add: ")
                currentBeans += readln().toInt()
                print("Write how many disposable cups of coffee do you want to add: ")
                currentCups += readln().toInt()
            }
            "take" -> {
                if (currentMoney > 0) {
                    println("\nI gave you $$currentMoney\n")
                    currentMoney = 0
                } else println("\nNo money left.\n")
            }
            "remaining" -> {
                println(
                    """
                
            The coffee machine has:
            $currentWater ml of water
            $currentMilk ml of milk
            $currentBeans g of coffee beans
            $currentCups disposable cups
            $$currentMoney of money    
            
            """.trimIndent()
                )
            }
            "exit" -> machineOn = false
            else -> "error"
        }
    }
}