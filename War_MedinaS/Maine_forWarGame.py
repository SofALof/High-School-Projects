#MAIN File for War Game Project - Sofia Medina

from Doubly_forWarGame import DoublyList
from Queue_forWarGame import Queue
import random

def addDeck(deck): #doublyLinked
    for i in range(1,53):
        deck.add(i)

def shuffle(deck): #doublyLinked
    size = deck.size()
    #goes through list finds random unshuffled int and has the current int and the unshuffled one switch places
    for i in range(0,size-1):

        randIndex = random.randint(i+1,size-1)
        randIndexValue = deck.pop(randIndex) 
        iValue = deck.pop(i)
       # print("randIndex:", randIndex,"| randValue:", randIndexValue,"| i:", i,"| iVal:", iValue)
        deck.insert(i, randIndexValue)
        deck.insert(randIndex-1, iValue) ### insert( pos, item)
        

def split(deck): #doubleLinked into TWO queues
    length = deck.size()
    divider = length/2 -1  #half way thro the deck

    hand1 = Queue()
    hand2 = Queue()
    
    for i in range(0,length):
        val = deck.pop()

        if i <= divider: #1/2 into hand1
            hand1.enqueue(val)      

        else:
            hand2.enqueue(val) #1/2 into hand2
   
    return hand1, hand2 

def defineCard(integer): #returns n which represents the suit and card which is a string of the card vlaue or tje name of the face card
    #0-12 -- Hearts [n= 0]
    #13-25 -- Diamonds [ n= 1]
    #26-38 -- Spades [n = 2]
    #39-51 -- Clubs [n= 3]
    
    integer -= 1 ##my cards are 1- 52 but the integer division only rlly works on 0-51
    n = integer//13
    cardNum = integer -n*13
    cardNum+=1

    card = ""
    if cardNum == 11:
        card = "Jack"
    elif cardNum ==  12:
        card = "Queen"
    elif cardNum == 13:
        card = "King"
    elif cardNum == 1:
        card = "Ace"
    elif cardNum == 10:
        card = "" + str(cardNum)
    else:
        card = "" + str(cardNum) + " "

    return(n ,card)

def asciiCardArt(integer): ##prints out ascii art of each card
    n ,card = defineCard(integer) 
    
    if card == "Jack": #spelling out each word takes up too much space so I settled for the first initial
        card = "J "
    elif card == "Queen":
        card = "Q "
    elif card == "King":
        card = "K "
    elif card == "Ace":
        card = "A "

    if n == 0: #hearts
        print(" _____")
        print("|" + card + "_  _ |")
        print("|(  v  )|") 
        print("|  \  /  |")
        print("|    .    |")
        print("|___ "+ card +"|")
      

    elif n == 1: #diamonds
        print(" _____ ")
        print("|" + card + " ^   |")
        print("|  / \  |")
        print("|  \ /  |")
        print("|    .   |")
        print("|___" + card +" |")
        
        
    elif n == 2: #Spades
        print(" _____ ")
        print("|" + card +" .   |")
        print("| /   \ |")
        print("|(_._)|")
        print("|    |   |")
        print("|____" + card + "|")
        

    elif n == 3: # clubs
         print(" _____ ")
         print("|" + card +"_   |")
         print("|  ( )  |")
         print("|(_'_)|")
         print("|   |    |")
         print("|___" + card + "|")
         

def printCard(integer): #returns a string to print out| does not immediatly print out for aesthetic rzns
    n, card = defineCard(integer)
    suit = ""
    if n == 0:
        suit = "Hearts"
    elif n == 1:
        suit = "Diamonds"
    elif n == 2:
        suit = "Spades"
    else:
        suit = "Clubs"

    
    return (card + "/" + suit)
   
def cardValue(integer): #returns the number on the card (or if its a face card - the vlaue that represents J, Q, or K)
    n = integer//13
    cardNum = integer -n*13
    cardNum+=1
    return cardNum

def playCard(hand): #
    card = hand.dequeue()
    return card
def gainCard(hand,card):
    hand.enqueue(card)


def outcome(playerCard, CPU_Card): #determines who wins or if its "time for war"
    playerValue = cardValue(playerCard) #returns an intget value to represent win/loss/warTime
    CPU_Value = cardValue(CPU_Card)         # and a string to print out

    if playerValue > CPU_Value:
       return "____You Win!_____", 0
    elif CPU_Value > playerValue:
        return "___CPU Wins :( __", 1 
    else:
        return "_!!TIME FOR WAR!!_",2


###################  White-Space for Funzies ############################
deck = DoublyList()
print()
print()
print()
print(" __           __       _                                       _             __            __               ")
print("\   \       /   /__ |  |  __  ___  _  __    ___    | |_ ___   \   \       /   /_  _  _   _  ")
print("  \   \/\/   / -_ )    / _ /  _  \  '     \/ -_)  |  _/  _  \   \   \/\/   /  _`  |  '_| ")
print("    \_ /\_ /\___ |_|\__\___/ _|_ |_\___|   \__\___/    \_ /\ _ /\__,_|_|     SM")
print()
print()
input("          Welcome to the Game of War. To begin your game press enter: ")
print("     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
print()
#########################################################################
acceptable = False
while(True):
    while(True):
        try:
            numDecks = int(input("          How many decks would you like to use? Type a number 1-6: "))
            break

        except ValueError:
            print("\n")
            print("     Please input an acceptable value.\n")
    if( numDecks > 0 and numDecks <= 6):
        break
    print("     Please input an acceptable value.\n")

for i in range(numDecks):
   addDeck(deck)

shuffle(deck)

playerCards, CPU_Cards = split(deck)
###################  White-Space for Funzies ############################
for i in range(6):
    print()
print("   ~_~_~_~_~_~_~_~_~_~_ shuffling and diving cards up ~_~_~_~_~_~_~_~_~_~_ ")
for i in range(6):
    print()

print("                                                       let's begin! ")
for i in range(6):
    print()

#########################################################################


allCards = Queue() ###Keeps track of the cards being played *crucial*

while(not playerCards.isEmpty() and not CPU_Cards.isEmpty() ):
    #Game Play continues until one player is out of cards
    allCards = Queue()
    input("____________________Press Enter to Continue____________________")

    for i in range(8):
        print()
    CPU_Card = playCard(CPU_Cards)
    print("CPU Plays: " + printCard(CPU_Card))#printed Card name
    asciiCardArt(CPU_Card) # ascii card art
    print("\n~~~~~~~~~~~\n") #spacing
    
    playerCard = playCard(playerCards)
    print("YOU Play: " +printCard(playerCard))#printed Card name
    asciiCardArt(playerCard)# ascii card art

    string, outcomeNum = outcome(playerCard, CPU_Card)
    print("\n\n _________________________")#spacing
    print("|____" + string + "____|\n\n")#spacing

    allCards.enqueue(CPU_Card)
    allCards.enqueue(playerCard)
    for i in range(2):
        print()

    while(True):
        if outcomeNum == 0: #Player Win
            for i in range(4):
                print()
            while not allCards.isEmpty():
                card = playCard(allCards)
                gainCard(playerCards, card)
            break
        elif outcomeNum == 1: #CPU_Win
            for i in range(4):
                print()
            while not allCards.isEmpty():
                card = playCard(allCards)
                gainCard(CPU_Cards, card)
            break
        
        else: #TIME FOR WAR
            CPU_fourCards = Queue()
            playerFourCards = Queue()

            input("____________________Press Enter to Continue____________________")
            
            for i in range(4):
                if not CPU_Cards.isEmpty():
                    CPU_Card =  playCard(CPU_Cards)
                    gainCard(CPU_fourCards, CPU_Card)
                    gainCard(allCards, CPU_Card) 
                    
                if not playerCards.isEmpty():
                    playerCard = playCard(playerCards)
                    gainCard(playerFourCards, playerCard)
                    gainCard(allCards, playerCard )
            
            CPU_Card = ""
            playerCard = ""

            someoneLost = False #boolean to see if someone ran out of cards but not an immediate break bc I need to print shtuff out
            
            print("CPU Plays: \n")
            if playerFourCards.size() != 4 or CPU_fourCards.size() != 4:
                someoneLost = True

            while not CPU_fourCards.isEmpty(): 
                CPU_Card = playCard(CPU_fourCards)
                print(printCard(CPU_Card))
                asciiCardArt(CPU_Card) #prints out all the cards for the war/ ascii and print


                print("\n\n")
            print("\n~~~~~~~~~~~\n")#white space

            print("YOU Play: \n")
            while not playerFourCards.isEmpty():
                playerCard = playCard(playerFourCards)
                print(printCard(playerCard))
                asciiCardArt(playerCard)#prints out all the cards for the war/ ascii and print
                print("\n\n")

            if someoneLost:
                break
            
            string, outcomeNum = outcome(playerCard, CPU_Card)
###################  White-Space for Funzies ############################            
            print("\n\n _________________________")
            print("|____" + string + "____|\n\n")
            for i in range(2):
                print()
#########################################################################             

if CPU_Cards.isEmpty():
    print()
    print()
    print()
    print(" _   _   ___   _    _    _  _  _    _   _     _ ")
    print("|  |  ||     ||   |  | |  |  |  ||  ||   \  |")
    print(" \    / |  | ||   '  | |  |  |  ||  ||       |")
    print("  |_|  |__   |___ '  |__/ _/ |_| |_ \_|")
else:
    print()
    print()
    print()
    print("  _   _  ___  _   _     _      ___    ___     ___")
    print("|  |  ||    ||  |  | |  |   |  . | / __>  | __>")
    print(" \    / | | ||  '  | |  |_ |  | | \__ \  | _> ")
    print("  |_|  |___ `___' |___|`__ '<___/ |___>")

              
    
