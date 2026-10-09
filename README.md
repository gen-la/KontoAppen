------------------------
Datasäkerhet, inkapsling
------------------------
Konton använder variablerna "name" och "balance" för att spara namn på konto och saldo. Dessa variabler är private. Det innebär att de kan bara ändras med de funktioner som finns i Account.java. På så sätt kan man inte skriva vad som helst och ändra dessa via Main eller någon annan fil.

-------------------------
Skapande-mönster, Factory
-------------------------
Förutom ovanstående anledning (private) så är det bra att dela upp ett program i flera delar. Konton skapas via registrets metod och kan anropas via Main. Detta är bra då man senare kan ändra koden i dessa metoder utan att behöva ändra något i Main. Varje klass får en egen funktion och koden blir lättare att återanvända, då man kan anropa funktioner från olika delar av programmet.

-----
Flöde
-----
1. När programmet startas får användaren se en meny med 6 alternativ. Om användaren väljer "5. Ta ut pengar" kommer valet (siffran 5) att sparas i variabeln "choice" och skickas till funktionen "getIntInput".
2. I denna funktion körs en while loop som först tar bort mellanslag och tab med "String line = scanner.nextLine().trim()" för att rensa bort de från input.
3. Sedan körs en if-sats som kontrollerar om inmatningen är tom, i så fall visas meddelandet "Ogiltig inmatning. Ange en siffra: " och användaren får mata in en siffra igen.
4. I nästa steg körs "try", här försöker programmet omvandla användarens inmatning till en integer med "int value = Integer.parseInt(line)" och kollar om inmatningen inte är en negativ siffra med if-satsen "if (value < 0)". Om inmatningen är negativ visas meddelandet "Input kan inte vara negativt. Ange ett positivt tal:" annars returneras värdet (siffran).
5. "catch" fångar upp error om inmatningen inte är en siffra och "int value = Integer.parseInt(line)" misslyckas. Då får användare se meddelandet "'" + line + "' är inte ett giltigt val. Ange en siffra: ", där line är användarens inmatning.
6. Om användaren har matat in en positiv siffra, returnas siffran till "choice" och programmet fortsätter vidare till "else if (choice == 5)". Här ombeds användare att mata in ett Namn som skickas vidare till AccountRegister med "Account found = register.findAccount(name)". Där körs funktionen findAccount som går igenom hela listan med konton, med hjälp av en for-loop. Loopen använder if-satsen "if (a.getName().equalsIgnoreCase(name)" för att ignorera skillanden på små och stora bokstäver och loopar igenom listan. Om ett matchande namn hittas returneras den, om inget hittas returnas null.
7. Tillbaka till Main, här fortsätter programmet att köra "if (found != null)". Om värdet som returnerades inte är null (betyder att en matchning hittades) kommer programmet be användaren att ange ett Belopp. Beloppet körs i funktionen getIntInput för att kontrolleras så att det är en positiv siffra. "if (amount > found.getBalance()" kontrollerar om det angivna beloppet är större än saldot som finns på kontot, i så fall får användaren meddelandet "Ogiltig summa, inte tillräckligt med pengar på kontot" och får mata in ett nytt belopp. Annars dras beloppet av från saldot och ett meddelande visar det nya saldot.
8. Om ingen matchning hittas när programmet letar efter en användare i listan med konton, visas meddelandet "Konto saknas"

----------
Reflektion
----------
Funktionen som kontrollerar om användaren matar in en positiv siffra var det som var svårast. Jag googlade runt på hur man kan hindra en användare från att mata in något annat än siffror, men kunde inte hitta något. Då googlade jag på hur man kan kolla om inmatningen är en siffra eller något annat och hittade try och catch. Kodexemplen var inte så lätta att förstå och det fanns ingen förklaring tillsammans med de, så jag vände mig till ChatGPT och bad den förklara steg för steg. Den förklarade så att jag förstod och fökortade koden och gjorde den enklare.
Jag stötte på problem med sökfunktionen, istället för att returnera det namn som användaren matat in fick jag antingen null eller en rad med siffror och bokstäver. Efter att ha kollat igenom koden noga såg jag att jag använt variabeln found istället för name i System.out.println(name).

-----------------------
Länk till redovisningen
-----------------------
https://funet-my.sharepoint.com/:v:/g/personal/3kdyhapp26_lahage_folkuniversitetet_nu/IQCMmjiF_ClcTaV8O50RQjhKAaCHpZZfpvWqfVdXB_Cas0w?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&e=KdekoD