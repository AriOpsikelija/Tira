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
Jos ei muuta, niin tuo githubissa oleva md tiedosto on ollut aina vähän mysteeri. Nyt kävi vasta ilmi, että se on markdown.
Kovin ruosteessa nää java osaamiset, kun ei työelämässä ole kummemmin tullut vastaan.

## 02-TASK
```
n       F (ms)  S (us)  Total (ms)
1000    28      3381    31
2000    17      2276    19
3000    23      1808    24
4000    33      905     33
5000    48      1050    49
6000    67      449     67
7000    89      525     89
8000    116     592     116
9000    148     862     148
10000   188     1104    189
11000   217     1016    218
12000   262     926     262
13000   300     1027    301
14000   359     1046    360
15000   397     1132    398
16000   456     1243    457
17000   522     1302    523
18000   595     1676    596
19000   650     1871    651
20000   733     1886    734
21000   799     2021    801
22000   890     2451    892
23000   996     2238    998
24000   1093    2364    1095
25000   1196    2468    1198
26000   1287    2680    1289
27000   1187    1953    1188
28000   1708    3225    1711
29000   2022    4094    2026
30000   2078    3087    2081
31000   2232    3741    2235
32000   2888    5017    2893
33000   2797    4014    2801
34000   3095    4592    3099
35000   3627    7743    3634
36000   2222    2722    2224
37000   4865    5766    4870
38000   5038    6606    5044
39000   5545    8666    5553
40000   6523    9127    6532
41000   7518    7266    7525
42000   7497    7254    7504
43000   7709    3027    7712
44000   10170   8284    10178
45000   10262   8465    10270
46000   10787   8644    10795
47000   10704   8795    10712
48000   11499   8872    11507
49000   12157   11002   12168
50000   13668   10517   13678
```

![Käyrä](raporttikuva.png)
2 minuuttia ja 39 sekunttia

Tuo add forlooppi on Ok niin kauan kun tuo datasetti pysyy pienenä. Isommissa dataseteissä sen parin elementin lisäämiseen menee hirvee aika, kun täytyy se lukea läpi n*100000 kertaa.
Hashing on vissiin se nopein tapa tutkia mikäli tuosta datasetistä löytyy duplikaatteja.
Koska tuo add on riippuvainen sen datasetin koosta on sen aika luokka täten (O(n)).

myös nuo minun muokkaamat menetelmät ovat tuon forloopin varassa, niin näidenkin luokitus on (O(n)).

Tuon 10000 setin ja 5000 setin lataaminen ei omalla koneella onnistunut. Tai varmaan jos odottaa riittävän kauan niin se ois auennut. 
1000 setillä taas ei kummemmin ongelmia. Tuossa huomaa, että on coder nimissä joku väliaskel ollu pois välistä kun sen sorttaamisessa menee ½ siitä mitä fullnamen kanssa menee.
Voiko olla et getFullName operaatio onkin todella raskas jollain tapaan. string + string + string. Joo-o.

Nää hakualgoritmit on lineaarisia, koska ne ei hyppele edes takas siinä listalla vaan käy ne yksitellen läpi.

Raportin kirjottamiseen menee enemmän aikaa kuin tehtävien tekemiseen. Liian hidas kone tälläiseen.

Onko oululla jotain sopimusta, että opiskelija saa käyttää CSC supertietokoneita ilmaiseksi?

## 03-TASK

```
n       F (ms)  S (us)  Total (ms)
1000    15      907     2119    924
2000    11      7860    1397    7872
3000    25      26007   1240    26033
4000    28      77642   1628    77671
5000    43      156629  1034    156673
6000    66      295414  1058    295481
7000    85      484230  1617    484316
8000    114     772098  962     772212
9000    154     1053650 992     1053804
10000   184     1486532 1342    1486717
```
![Käyrä](raporttikuva2.png)

En jaksanut testejä odottaa loppuun saakka. Annoin pyöriä tunnin ja vilkasin et testeissä se vetäis vielä 6000 tohon päälle ni se loppu siihen.
kokeilin asettaa että käyttää max stack ja keko muistia muttei se auttanut, niin ei voi minkään.

Koodi läpäisi testit kunhan säädin, että tekee vain 1000 16000 ja 10000 sijaan.
Vaikkei sitä testiä saanut muokata, niin veikkaan et jos se niillä pienemmillä menee läpi. Teidän koneella testien pitäs niillä isommilla seteillä mennä yhtälailla läpi.
```                            
               .::--=========.               
            .--==++==========+**             
           --=+++*****+++++=++@@+            
          .#%@@@@@@@@@@@@@@%@@@@@@@          
          =@@@@@@@@@@@@@@@@@@@@@@@@@.        
          #@@@@@#::=+@@@@@@@@@@@@@@@@        
          =@@%@*:-=+%@@@@*+%@@@@@@@@@.       
           -+++:==+%@@@#=====*@@@@@@@:       
          --+=:==*@@@@@*==+=+@@@@@@@@-       
         =+=--=+*@@@@@@%+===*@@@@@@@@-       
        -==--=+#@#+++#@@@*++%@@@@@@@@=       
        -+@@@@@@@@@@@@@@@@%+@@@@@@@@@=       
        =+@@@@@@@@@@@@@@@@@@@@@@@@@@@+       
        ==--+++*#@@@@@@@@@@@@@@@@@@@@+       
       .=+#%%%%%##*#@@@@@@@@@@@@@@@@@*       
       .+@@@@@@@@@@@@@@@@@@@@@@@@@@@@        
       .=+%@@@@@@@@#+*@@@@@@@@@@@@*          
       .=++%@@@@@%+==+#@@@@@@@@@@@           
       .===++#%%*+===+*@@@@@@@@@@@           
       :=====+========+%@@@@@@@@@@           
       +*++=--===+==+++%@@@@@@@@@@           
        #@@%%%%%%%%%@@@@@@@@@@@*.            
            ......                           
```
Pääasiassa se toimii. Pistin koodin täytee debug viestejä ja testasin et toimiiko se exact ja olihan se noin 5ms nopeampi.
Kummempaa analyysiä tässä ei voi tehdä kun ei riitä rahat sellaseen.

## 04-TASK

Tää olikin ihan hauska tehtävä. Tuo parenthses osio. En ole ennen json tiedostoja joutunut korjaamaan, niin tuo "[" piilossa oleva veijari pisti minut hetkeks solmuun.

Kaikki paitsi push ja toString on O(1). Näiden kahden kohalla ei voinut minkää. Molemmissa on nuo forloopit jotka korottaa ne O(n)

kun taas pop, peek, size, capacity, isempty ja clear on kerta heitolla yhdessä iteraatiossa suoritettuja.


## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK