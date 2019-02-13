# learning-akka-http

### Run application 

       $ sbt run 
       
 #### test rest endpoints 
       // get all persons
       $ curl -XGET 'localhost:8000/person/getAll'
         output => [{"name":"Bob","email":"bob@gmail.com","age":32}]
       
       //get person by name
       $ curl -XGET 'localhost:8000/person/getByName?name=bob'
                output => [{"name":"Bob","email":"bob@gmail.com","age":32}]
                
        
        // save person  
       $ curl -XPOST 'localhost:8000/person/save' -d'{"name":"Joy","email":"joy@gmail.com","age":30}'
        // Person saved successfully
        
