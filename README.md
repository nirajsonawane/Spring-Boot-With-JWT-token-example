# Spring-Boot-With-JWT-token-example
Spring Boot With JWT token example


 curl -X POST http://localhost:8080/authenticate -H "Content-Type:application/json" -d "{\"userName\":\"niraj.sonawane@gmail.com\",\"password\":\"test\"}"
 
 curl -X POST http://localhost:8080/authenticate -H "Content-Type:application/json" -d "{\"userName\":\"test@gmail.com\",\"password\":\"niraj\"}"
 
 curl -X GET http://localhost:8080/Student -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJEZW1vIEFwcCIsImlhdCI6MTU2MzA5NTE1NCwiZXhwIjoxNTYzMDk1NjU0LCJSb2xlcyI6WyJBZG1pbiJdfQ.8XyZGx9p5yOtSKzSeMkf33S5mItuJBP0y2yMM4pbGIQAJPs8lBixP2tp6-kdCEG92PcJoALFz45qFEFKid2-uA"