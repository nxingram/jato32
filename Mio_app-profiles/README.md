# Profilo attivo: win o mac
spring.profiles.active=

# nome dell'applicazione, che uso come variabile in welcome.message
app.name=Profili Spring Boot

# messaggi che posso usare nel controller
# sotto trovo i valori di default, negli altri file metto le versioni del profilo corrispondente
welcome.message=Welcome to ${app.name}
basic.message=Basic


# Stessa cosa è fattibile per le impostazioni database
# aggiungere ai vari profili le proprietà valorizzate rispettivamente al profilo
spring.datasource.url=jdbc:mysql://localhost:3306/projectwork
spring.datasource.username=app_generation
spring.datasource.password=generation_2021!?