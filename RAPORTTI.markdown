# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK
Revision:
Se ei ehkä mennyt ekalla kerralla ihan oikein, mutta bubblesortilla on siistimpi nimi kuin insertionsortilla. Se oli ihan tehä tää virhe, niin pääsee vertailee miten O(n^2) näyttää 
O(n) verrattuna.

## 02-TASK
Revision:
```
n       F (ms)  S (us)  Total (ms)
1000    37      3843    40
2000    13      3899    16
3000    24      1963    25
4000    38      998     38
5000    54      1203    55
6000    70      544     70
7000    90      857     90
8000    117     786     117
9000    150     794     150
10000   180     874     180
11000   217     984     217
12000   260     1094    261
13000   312     1201    313
14000   353     1248    354
15000   411     1917    412
16000   462     1481    463
17000   528     2412    530
18000   590     1664    591
19000   662     1707    663
20000   819     1876    820
21000   835     1919    836
22000   881     2023    883
23000   983     2248    985
24000   1099    2266    1101
25000   1321    2492    1323
26000   1321    2321    1323
27000   1610    2446    1612
28000   1825    3192    1828
29000   1782    2760    1784
30000   2133    3056    2136
31000   2183    3183    2186
32000   2383    3249    2386
33000   2691    3607    2694
34000   3024    3962    3027
35000   3531    4181    3535
36000   4318    4765    4322
37000   2446    3288    2449
38000   4736    7312    4743
39000   5621    5766    5626
40000   7260    14014   7274
41000   8274    6751    8280
42000   8063    9164    8072
43000   10522   6993    10528
44000   11436   6946    11442
45000   11493   8216    11501
46000   9984    9256    9993
47000   11285   9435    11294
48000   12845   13111   12858
49000   11431   9426    11440
50000   13102   9471    13111
```

![Käyrä](raporttikuva1revisio.png)

Noh nyt tässä tehtävässä onkin jotai analysoitavaa, kun vertaa insertionsorttia ja tuota aijempaa bubblesorttia. Nähdään että on inserttionsort vähän hitaampi tuolla alussa.
Sit ihan loppuun kun tullaan niin se ohittaa bubblesortin. Katos mie osaan valita tilannepäisesti vaistosta tuon oikean sorttaus algorytmin, niin sentakia aluksi toteutukseni oli bubblesort. Ei voi minkään. Sit sen unohtaa et se oli tosiaan toteutettu takaraivosta. Nyt vasta jälkeenpäi tuli viestiä sähköpostiin et se ratkasu oli tosiaan väärä täälä alussa.


## 03-TASK
Revision: 
```
n       F (ms)  S (us)  Total (ms)
1000    16      24      2313    42
2000    9       15      1074    25
3000    21      24      347     45
4000    32      28      333     60
5000    50      47      419     97
6000    65      91      780     156
7000    90      104     633     194
8000    124     135     1055    260
9000    151     155     743     306
10000   185     217     1093    403
11000   226     233     1247    460
12000   281     287     993     568
13000   328     393     1525    722
14000   372     490     1624    863
15000   438     531     1747    970
16000   472     617     2219    1091
```
![Käyrä](raporttikuva2revisio.png)

Se oli vasta tässä tehtävässä kun bubblesortin rajoitukset korostui. Kuka olisi voinut arvata. 


## 04-TASK

Tää olikin ihan hauska tehtävä. Tuo parenthses osio. En ole ennen json tiedostoja joutunut korjaamaan, niin tuo "[" piilossa oleva veijari pisti minut hetkeks solmuun.

Kaikki paitsi push ja toString on O(1). Näiden kahden kohalla ei voinut minkää. Molemmissa on nuo forloopit jotka korottaa ne O(n)

kun taas pop, peek, size, capacity, isempty ja clear on kerta heitolla yhdessä iteraatiossa suoritettuja.


## 05-TASK

En tehnyt molempia toteutuksia, mutta ammuin itseäni senverran lujaa jalkaan, että osaan arvostaa tuota linkitettyä listaa.
Tein sellaisen virheen, että kopioin lähestulkoon kaikki funktiot viime tehtävästä ja täten aiheutin viime partailla ongelmia sen listan koon ja tail head systeemin kanssa.
Tässä ei olisi ollut ongelmaa mikäli oisin tehnyt linkitetyn listan alustapitäen. Sillä linkitetyssä listassa voi vain poistaa niitä elementtejä mennen tullen. Kun tuota array 
systeemiä pitää vahtia, että missä siellä mennään. 

Eli ongelmaksi kävi seuraava scenaario. 5,6,7,_,_,_,_,6,7,8 lisättiin elementti ja mokasin tuli listasta seuraava -> 5,6,7,_,_,_,_,6,7,8,9,_,_,_,_,_,_,_,_,_,_,_,_,_
tavotehan oli 6,7,8,9,5,6,7,_,_,_... Selvittiin siitä. Oltas selvitty helpommalla linkitetyllä listalla. 

Kyllä kaikki paitsi enque ja toString täyttää vaatimukset O(1). Ja tuo toString oli myös sellane jonka kanssa tuli ongelmia ku kopioi viime tehtävän.



## 06-TASK
Revision:
Taas se on hoidettu korjattu eka tehtävä, niin saatii lisää tuloksia ja vertauksia bubblesortin ja insertionsortin välillä.

|Test#   |   Count        |ms          |    ms/element|
|--------|--------|-------|--------------|
|  1      |    100       |        2     |      0,020|
|  2      |   1000      |        77      |     0,077|
 | 3     |    5000     |        632       |    0,126|
 | 4     |   10000    |        5456        |   0,546|
 | 5     |   50000   |       114707         |  2,294|


|Test#    |  Count      |  ms             | ms/element|
|-----|--------|--------|-------|
|  1      |    100  |            15       |    0,150|
|  2     |    1000   |           10      |     0,010|
|  3    |     5000    |          25     |      0,005|
|  4   |     10000     |         37    |       0,004|
|  5  |      50000      |       169   |        0,003|
|  6 |      100000       |      571  |         0,006|

InsertionSort on astronomisesti hitaampi kuin tämä quicksort, koska quicksort skooppi aina pienenee joka iteraatiolla kun taas tuo insertionsort on edelleen O(n)


![Käyrä](raporttikuva3revision.png)
![Käyrä](raporttikuva4.png)

Tuo fastsort ei ole muuttunut niin kuva 4 on edelleen oikein.
## 07-TASK

## 08-TASK

## 09-TASK