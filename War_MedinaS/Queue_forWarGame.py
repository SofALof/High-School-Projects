#QUEUE File for War Game Project - Sofia Medina

class Queue:

    def __init__ (self): # Creates a new list that is empty. It needs no parameters and creates an empty list.
        self.__length = 0
        self.__head = None
        self.__end = None

    def front (self):
        return self.__head
                    
        
    def enqueue (self, item): # Adds a new item to the list at position pos. It needs the item and returns nothing.  Make sure the item is not already in the list and there are enough existing items to have position pos.
        if self.isEmpty():
            self.__head = Node(item, None,None)
            self.__end = self.__head
            
        else:
            newNode = Node(item, None, self.__end)
            self.__end.setNext(newNode)
            self.__end = newNode
            #print(self.__end.getPrev())

        self.__length +=1
 
    def dequeue (self): #removes the front item from the queue. It needs no parameters and returns the item. The queue is modified.
        if not self.isEmpty():
          data = self.__head.getData()
          if self.__length ==1:
            self.__head = None
            self.__end = None
          else:
            self.__head = self.__head.getNext()
            self.__head.setPrev(None)
            
          self.__length -=1
          return data
     
    def isEmpty(self): # tests to see whether the queue is empty. It needs no parameters and returns a boolean value.
        return self.__length == 0

    def size(self): # returns the number of items in the queue. It needs no parameters and returns an integer.
        return self.__length
    
    def __str__ (self): #returns what is in the queue. It needs no parameters and returns a string.
        if self.__head == None:
            return "[]"
        s = "["
        current = self.__head
        while current.getNext() != None: #goes until the penultimate node
            s += str(current.getData()) + ","
            current = current.getNext() 
        s += str(current.getData())
        return s + "]"



class Node:
    def __init__(self, data=None, next=None, prev=None):
        self.__data = data
        self.__next = next
        self.__prev = prev

    def getData(self):
        return self.__data

    def getNext(self):
        return self.__next
    def getPrev(self):
        return self.__prev

    def setData(self, newData):
        self.__data = newData

    def setNext(self, newNext):
        self.__next = newNext

    def setPrev(self, newPrev):
        self.__prev = newPrev

    def __repr__(self):
        return self.__data

    def __str__(self):
        return str(self.__data)

