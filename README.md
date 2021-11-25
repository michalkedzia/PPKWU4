# String API
API umozliwiające uzysaknie indormacji o Stringu przekazanym
w parametrze zapytania GET.W odpowiedzi dostajemy informacje o ilości
wielkich i małych liter, ilości liczb itp. Odpowiedź możemy uzyskac w 4 formatach: text,json,csv i xml.
Api to odwołuje sie do innych zewnętrznych API. Użytkownik podaje format który chce otrzymac i format który wysyłany jest do API.
Aplikacja jest uruchamiana na porcie 8082.


## Składnia
```
api_path/{format_który_chcemy_otrzymać}/{format_w_jakim_odbieramy_dane_z_API}/{parameter_text} 
```
## Przykład
```
http://localhost:8082/api/v2/json/csv/ABCabc123@!@
http://localhost:8082/api/v2/csv/json/ABCabc123@!@
http://localhost:8082/api/v2/text/xml/ABCabc123@!@
```
## Wynik
Odpwiedź w formacie JSON:
```json
{
  "parameter": "ABCabc123@!@",
  "length" : 12, 
  "digits": 3,
  "upperCase": 3,
  "lowerCase": 3,
  "whitespace": 0,
  "specialCharacters": 3
}
```

Odpwiedź w formacie XML:
```xml
<StringResponse>
<parameter>ABCabc123@!@</parameter>
<length>12</length>
<digits>3</digits>
<upperCase>3</upperCase>
<lowerCase>3</lowerCase>
<whitespace>0</whitespace>
<specialCharacters>3</specialCharacters>
</StringResponse>
```
Odpwiedź w formacie text:
```text
parameter: ABCabc123@!@ digits: 3 upperCase: 3 lowerCase: 3 whitespace: 0 specialCharacters: 3
```

Odpwiedź w formacie CSV:
```csv
parameter,digits,upperCase,lowerCase,whitespace,specialCharacters
ABCabc123@!@,3,3,3,0,3
```