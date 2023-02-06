#DOUBLY File for War Game Project - Sofia Medina

class DoublyList:

    def __init__ (self): # Creates a new list that is empty. It needs no parameters and creates an empty list.
        self.__length = 0
        self.__head = None
        self.__end = None

    def add (self, item): #Adds a new item to the beginning of the list. It needs the item and returns nothing.  Make sure the item is not already in the list.

        if self.__head == None:
            self.__head = Node(item, None, None)
            self.__end = self.__head

        else:
            t= self.__head
            newNode = Node(item, t, None)
            self.__head = newNode
            t.setPrev(self.__head)

        self.__length +=1


    def append(self, item): #Adds a new item to the end of the list making it the last item in the collection. It needs the item and returns nothing. Assume the item is not already in the list.
        if not self.search(item):
            if self.__head == None:
                self.__head = Node(item, None, None)
                self.__end = Node(item,None, None)
                
            else:
                t = self.__end
                newNode = Node(item, None, t)
                self.__end = newNode
                t.setNext(self.__end)
                if self.size() == 1:
                  self.__head = t

            self.__length +=1
                    
        
    def insert (self, pos, item): # Adds a new item to the list at position pos. It needs the item and returns nothing.  Make sure the item is not already in the list and there are enough existing items to have position pos.

        if self.isEmpty() or pos == 0:
            self.add(item)
            
        elif pos == self.size():
            self.append(item)

        elif pos < self.size():
            current = self.__head.getNext()

            for i in range(pos-1):
                current = current.getNext()
            
            previous = current.getPrev() ##
            newNode = Node(item, current, previous) ##next, previous
            current.setPrev(newNode)
            previous.setNext(newNode)
            self.__length +=1

    def pop (self, pos=0): # Removes and returns the item at position pos or the first item is no position is given. It needs the position and returns the item. 
        if pos >= self.size():
            return
        
        if self.isEmpty():
          return
        
        elif self.size() == 1: ## if one element
            data = self.__head.getData()
            self.__head == None
            self.__end == None
            return data

        elif pos == 0: ##if first 
            data = self.__head.getData()
            self.__head = self.__head.getNext()
            self.__head.setPrev(None)
            self.__length -=1
            return data
            
        elif pos +1 == self.size(): ##if last
            data = self.__end.getData()
            self.__end = self.__end.getPrev()
            self.__end.setNext(None)
            self.__length -=1
            #print(self.__end.getPrev())
            return data

       #print(pos)
        current = self.__head
        for i in range(pos):
          current = current.getNext() ###
        
        previous = current.getPrev()
        post = current.getNext()
        previous.setNext(post) 
        post.setPrev(previous)
        self.__length -=1
        return current.getData()
    
    def remove (self, item): # Removes the item from the list. It needs the item and modifies the list. Assume the item is present in the list.
        if not self.isEmpty() and self.__head.getData() == item:
            if self.__length == 1:
              self.__head = None
              self.__end = None
              self.__length -=1
               
            else:
              t = self.__head.getNext()
              t.setPrev(None)
              self.__head = t
              self.__length -=1

              if self.__length == 1:
                self.__end = self.__head
                
           
            
            
        elif not self.isEmpty() and self.__end.getData() == item:
            t = self.__end.getPrev()
            t.setNext(None)
            self.__end = t
            self.__length -=1
            
            if self.__length == 1:
              self.__head = self.__end
            
        elif  not self.isEmpty() and self.__head != None:
            
            theItem = False
            current = self.__head
            while current.getNext() != None:
                if current.getData() == item:
                    theItem = True
                    break
                current = current.getNext()
            if theItem:
                previous = current.getPrev()
                next = current.getNext()
                previous.setNext(next)
                next.setPrev(previous)
                self.__length -=1
    
    def index (self, item): #Returns the position of item in the list. It needs the item and returns the index.  Make sure the item is in the list.
        if self.search(item):

            count = 0
            current = self.__head
            while current.getNext() != None:
                if current.getData() == item:
                    return count
                current = current.getNext()
                count+=1
                
            if current.getData() == item:
                return count
            return -1
            
        
    def search (self, item): #Searches for the item in the list. It needs the item and returns a boolean value.
        if self.__head ==  None:
            return False
        current = self.__head
        
        while current.getNext() != None:
            if current.getData() == item:
                return True
            current = current.getNext()
            
        return current.getData() == item
    
    def isEmpty(self): # Tests to see whether the list is empty. It needs no parameters and returns a boolean value.
        return self.__length == 0

    def size(self): # Returns the number of items in the list. It needs no parameters and returns an integer.
        return self.__length
    
    def __str__ (self): #Returns a str of the doubly linked list from first to last and should include []
        if self.__head == None:
            return "[]"
        s = "["
        current = self.__head
        while current.getNext() != None: #goes until the penultimate node
            s += str(current.getData()) + ","
            current = current.getNext() 
        s += str(current.getData())
        return s + "]"

    def doubly_list(self): #Returns a str of the doubly linked list from last to first and should include []
        if self.__end == None:
            return "[]"
        s = "["
        current = self.__end
        while current.getPrev() != None: #goes until the penultimate node
            s += str(current.getData()) + ","
            current = current.getPrev() 
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

