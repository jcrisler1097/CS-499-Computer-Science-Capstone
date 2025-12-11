#Jordan Crisler
#Professor Kayl
#CS-340-10603-M01 Client/Server Development 2025 C-3
#June 6, 2025

from pymongo import MongoClient
from bson.objectid import ObjectId

class AnimalShelter(object): #Creates AnimalShelter class
    """ CRUD operations for Animal collection in MongoDB """

    def __init__(self, username, password, host, port, database, collection):
        # Initializing the MongoClient. This helps to
        # access the MongoDB databases and collections.
        # This is hard-wired to use the aac database, the
        # animals collection, and the aac user.
        # Definitions of the connection string variables are
        # unique to the individual Apporto environment.
        #
        # You must edit the connection variables below to reflect
        # your own instance of MongoDB!
        #
        # Connection Variables
        #
        USER = username #MongoDB username
        PASS = password #MongoDb password
        HOST = host #MongoDB host
        PORT = port #MongoDB port
        DB = database #Database
        COL = collection #Collection
        #
        # Initialize Connection
        #
        self.client = MongoClient('mongodb://%s:%s@%s:%d' % (USER,PASS,HOST,PORT)) #Creates connection using connection variables
        self.database = self.client['%s' % (DB)] #Selects database
        self.collection = self.database['%s' % (COL)] #Selects collection

# Complete this create method to implement the C in CRUD.
    def create(self, data):
        if data is not None and isinstance(data, dict):
            result = self.database.animals.insert_one(data)  # data should be dictionary
            return result.inserted_id #Returns ID inserted
            print("Insert acknowledged:", result.acknowledged) #Result acknowledged
        else:
            raise Exception("Nothing to save, because data parameter is empty.") #Raises exception if no document to save

# Create method to implement the R in CRUD.
    def read(self, query):
        # Searches for data matching query
        if query is not None and isinstance(query, dict):
            results = self.database.animals.find(query) #Results equals query using find function for matching data
            return results #Returns results
        else: 
            raise Exception("No matching query result found.") #Exception if no data found
        
# Create method to implement the U in CRUD.
    def update(self, query, update):
        #Searches for data matching result to update
        if query is not None and isinstance(query, dict) and update is not None and isinstance(update, dict):
            results = self.database.animals.update_one(query, {"$set": update}) #Results equals query to update function
            return results.modified_count
        else:
            raise Exception("No matching data to update.") #Exception if no matching data found to update
            
# Create method to implement the D in CRUD.
    def delete(self, delete): 
        if delete is not None and isinstance(delete, dict):
            results = self.database.animals.delete_one(delete) #Results equals query to delete function
            return results #Returns results
        else:
            raise Exception("No matching data to delete.") #Exception if no matching data to delete found
