# Name:        Jordan Crisler
# Professor:   Professor Conlan
# Course:      CS-499-14507-M01 Computer Science Capstone 2025 C-6
# Date:        November 28, 2025
# Artifact 2

from pymongo import MongoClient
from bson.objectid import ObjectId

class AnimalShelter(object): #Creates AnimalShelter class
    """ CRUD operations for Animal collection in MongoDB """

    def __init__(self, username, password):
        # Initializing the MongoClient. This helps to access the MongoDB databases and collections.
        # This is hard-wired to use the aac database, the animals collection, and the aac user.
        #
        # Connection Variables     
        USER = username #MongoDB username
        PASS = password #MongoDb password
        HOST = 'cluster0.gqtlpus.mongodb.net' #MongoDB host
        ##PORT = 27017 #MongoDB port
        DB = 'AAC' #Database
        COL = 'animals' #Collection
        
        # Initialize Connection
        self.client = MongoClient('mongodb://%s:%s@%s' % (USER,PASS,HOST)) #Creates connection using connection variables
        self.database = self.client['%s' % (DB)] #Selects database
        self.collection = self.database['%s' % (COL)] #Selects collection

# Method to create one record.
    def createOne(self, data):
        if data is not None and isinstance(data, dict):
            result = self.database.animals.insert_one(data)  # data should be dictionary
            return result.inserted_id #Returns ID inserted
            print("Insert acknowledged:", result.acknowledged) #Result acknowledged
        else:
            raise Exception("Nothing to save, because data parameter is empty.") #Raises exception if no document to save

# Method to create many records.
    def createMany(self, data):
        if data is not None and isinstance(data, dict):
            result = self.database.animals.insert_many(data)  # data should be dictionary
            return result.inserted_id #Returns IDs inserted
            print("Insert acknowledged:", result.acknowledged) #Result acknowledged
        else:
            raise Exception("Nothing to save, because data parameters are empty.") #Raises exception if no document to save

# Method to read one record.
    def read(self, query):
        # Searches for data matching query
        if query is not None and isinstance(query, dict):
            results = self.database.animals.find(query) #Results equals query using find function for matching data
            return results #Returns results
        else: 
            raise Exception("No matching query result found.") #Exception if no data found
        
# Method to update one record.
    def updateOne(self, query, update):
        #Searches for data matching result to update
        if query is not None and isinstance(query, dict) and update is not None and isinstance(update, dict):
            results = self.database.animals.update_one(query, {"$set": update}) #Results equals query to update function
            return results.modified_count
        else:
            raise Exception("No matching data to update.") #Exception if no matching data found to update

# Method to update many records.
    def updateMany(self, query, update):
        #Searches for data matching result to update
        if query is not None and isinstance(query, dict) and update is not None and isinstance(update, dict):
            results = self.database.animals.update_many(query, {"$set": update}) #Results equals query to update function
            return results.modified_count
        else:
            raise Exception("No matching data to update.") #Exception if no matching data found to update
            
# Method to delete one record.
    def deleteOne(self, delete): 
        if delete is not None and isinstance(delete, dict):
            results = self.database.animals.delete_one(delete) #Results equals query to delete function
            return results #Returns results
        else:
            raise Exception("No matching data to delete.") #Exception if no matching data to delete found

# Method to delete many records.
    def deleteMany(self, delete): 
        if delete is not None and isinstance(delete, dict):
            results = self.database.animals.delete_many(delete) #Results equals query to delete function
            return results #Returns results
        else:
            raise Exception("No matching data to delete.") #Exception if no matching data to delete found

# Method to replace one record.
    def replaceOne(self, query, replace):
        #Searches for data matching result to update
        if query is not None and isinstance(query, dict) and replace is not None and isinstance(replace, dict):
            results = self.database.animals.replace_one(query, {"$set": replace}) #Results equals query to replace function
            return results.modified_count
        else:
            raise Exception("No matching data to update.") #Exception if no matching data found to update

# Method to replace many records.
    def replaceMany(self, query, replace):
        #Searches for data matching result to update
        if query is not None and isinstance(query, dict) and replace is not None and isinstance(replace, dict):
            results = self.database.animals.replace_many(query, {"$set": replace}) #Results equals query to replace function
            return results.modified_count
        else:
            raise Exception("No matching data to update.") #Exception if no matching data found to update