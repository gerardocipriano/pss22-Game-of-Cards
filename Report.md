# Relazione per Progettazione e Sviluppo del Software

# Analisi

## Requisiti

Il gruppo si è posto l'obiettivo di sviluppare un software ispirato al gioco di carte di Evoland 2 (“Game of Cards”).  

Il gioco si compone di partite disputate tra due giocatori su uno stesso schermo. Prima dell’inizio della partita i giocatori compongono il mazzo di carte che entrambi utilizzeranno oppure ne scelgono uno tra quelli composti in precedenza. A turno, due giocatori utilizzano le proprie carte per sconfiggere l'avversario. La partita finisce quando i punti vita di uno dei partecipanti arrivano a zero.

### Requisiti funzionali 

- [ ] <b>Creazione delle carte</b>: i giocatori attraverso un’apposita interfaccia possono creare delle carte personalizzate specificando per ciascuna il nome della carta, punti vita, costo, attacco, difesa e abilità 

- [ ] <b>Creazione del mazzo</b>: i giocatori attraverso un’apposita interfaccia possono assemblare un mazzo scegliendo tra tutte le carte a disposizione 

- [ ] <b>Gestione della partita player vs player</b>: la partita si svolgerà su un campo di gioco suddiviso in 12 caselle in formato 4x3 e diviso in due parti speculari (una per giocatore). Durante il proprio turno, ogni giocatore potrà posizionare le carte nella propria parte di campo. Alla fine del turno le carte in campo si scontreranno contro quelle dell’avversario, eliminandosi a vicenda o sottraendo punti vita all’avversario.   

- [ ] <b>Menu principale</b>: il software si aprirà dalla schermata principale, dove l'utente troverà un menu che gli permetterà di scegliere se iniziare una nuova partita o accedere alle altre funzionalità. Inoltre, sarà presente un tutorial per coloro che vogliono rinfrescare le regole del gioco. 

### Requisiti non funzionali 

- [ ] <b>Impostazioni</b>: gestione dell'audio e fullscreen dell'applicazione

- [ ] <b>Sviluppo di una modalità di gioco player vs CPU</b>: implementazione di una seconda modalità di gioco in cui un singolo giocatore potrà sfidare il software 

- [ ] <b>Animazioni</b> di pescata e attivazione effetto delle carte durante la partita 

### Elementi positivi

-   Si fornisce una descrizione in linguaggio naturale di ciò che il
    software dovrà fare.
-   Gli obiettivi sono spiegati con chiarezza, per punti.
-   Se vi sono termini il cui significato non è immediatamente
    intuibile, essi vengono spiegati.
-   Considerato a un paio di pagine un limite ragionevole alla lunghezza
    della parte sui requisiti, in quello spazio si deve cercare di
    chiarire *tutti* gli aspetti dell'applicazione, non lasciando
    decisioni che impattano la parte "esterna" alla discussione del
    design (che dovrebbe solo occuparsi della parte "interna").

### Elementi negativi

-   Si forniscono indicazioni circa le soluzioni che si vogliono
    adottare.
-   Si forniscono dettagli di tipo tecnico o implementativo (parlando di
    classi, linguaggi di programmazione, librerie, eccetera).


## Analisi e modello del dominio

All’interno della partita entrano in gioco diverse entità. I giocatori si affrontano con lo stesso mazzo. I mazzi sono composti da diverse carte. Le carte sono posizionate sul terreno di gioco. 
I giocatori hanno a disposizione una certa quantità di punti vita e di mana. Quando i punti vita di uno dei giocatori arriva a 0, il gioco termina. Il mana a disposizione dei giocatori è utilizzato per evocare le varie carte che si pescano.  

Prima della partita, è possibile comporre un deck con le carte a disposizione. Ogni deck ha un nome e l’elenco delle carte da cui è composto. Le carte sono posizionate su un campo di gioco.  

Il campo è composto da una griglia in formato 4x3 e diviso in due parti speculari, una per giocatore. Durante il turno di ciascun giocatore, è possibile decidere dove posizionare le carte sul campo. 

Il Match è un'entità astratta che lega fra di loro il Giocatore e il campo di gioco. Si occupa di gestire la logica di gioco come l'inzio e la fine di una partita.



```mermaid
classDiagram

    class Player {
        +draw(Deck): List~Card~
        +discard()
        +play()
    }
    <<interface>> Player

    class Match {
        +startMatch()
        +endMatch()
        +changePlayer()
        +checkLife()
    }
    <<interface>> Match   

    class GameField {
        +arrange()
        +fight()
    }
    <<interface>> GameField

    class Deck {
    }
    <<interface>> Deck

    class Card {
    }
    <<interface>> Card

    Match -- Player
    Match -- GameField
    GameField -- Deck
    Deck -- Card 
```

Data la complessità di elaborare una strategia di gioco per il computer, la prima versione software fornita non prevederà la modalità giocatore 1 versus CPU.
 


# Design

## Architettura

L'architettura di Game of Cards segue il pattern architetturale MVC, in cui ogni aspetto funziona in autonomia per garantire un'organizzazione efficiente. In particolare, l'intero modello si basa sulla classe Match che coordina tutte le funzionalità della partita che abbiamo aggiunto. Ogni volta che si verificano eventi sul terreno di gioco, quest'ultimo notifica i cambiamenti al controller del Match; il controller si occuperà poi di aggiornare di conseguenza gli elementi grafici. In questo modo, possiamo garantire il funzionamento dell'applicazione anche se si dovesse optare per una GUI diversa, senza essere vincolati ad una libreria grafica specifica.

``` mermaid
classDiagram

    class Model {
    }
    
    class Match {
    }
    <<interface>> Match
    
    class Controller {
    }
    
    class View {
    }
    
    Controller -- View 
    Match -- Controller
    Model -- Match
```

### Elementi positivi

-   Si mostrano pochi, mirati schemi UML dai quali si deduce con
    chiarezza quali sono le parti principali del software e come
    interagiscono fra loro.

### Elementi negativi

-   Si presentano UML caotici, difficili da leggere.
-   Si presentano UML in cui sono mostrati elementi di dettaglio non
    appartenenti all'architettura, ad esempio includenti campi o con
    metodi che non interessano la parte di interazione fra le componenti
    principali del software.
-   Si presentano schemi UML con classi (nel senso UML del termine) che
    "galleggiano" nello schema, non connesse, ossia senza relazioni con
    il resto degli elementi inseriti.
-   Si presentano elementi di design di dettaglio, ad esempio tutte le
    classi e interfacce del modello o della view.
-   Si discutono aspetti implementativi, ad esempio eventuali librerie
    usate oppure dettagli di codice.

### Esempio

L'architettura di GLaDOS segue il pattern architetturale MVC. Più nello
specifico, a livello architetturale, si è scelto di utilizzare MVC in
forma "ECB", ossia "entity-control-boundary"[^4]. GLaDOS implementa
l'interfaccia AI, ed è il controller del sistema. Essendo una
intelligenza artificiale, è una classe attiva. GLaDOS accetta la
registrazione di Input ed Output, che fanno parte della "view" di MVC, e
sono il "boundary" di ECB. Gli Input rappresentano delle nuove
informazioni che vengono fornite all'IA, ad esempio delle modifiche nel
valore di un sensore, oppure un comando da parte dell'operatore. Questi
input infatti forniscono eventi. Ottenere un evento è un'operazione
bloccante: chi la esegue resta in attesa di un effettivo evento. Di
fatto, quindi, GLaDOS si configura come entità *reattiva*. Ogni volta
che c'è un cambio alla situazione del soggetto, GLaDOS notifica i suoi
Output, informandoli su quale sia la situazione corrente.
Conseguentemente, GLaDOS è un "observable" per Output.

Il seguente è lo schema UML architetturale di GLaDOS.
L'interfaccia `GLaDOS` è il
controller del sistema,
mentre `Input` ed `Output` sono le interfacce
che mappano la view (o, più correttamente in questo specifico esempio,
il boundary). Un'eventuale interfaccia grafica interattiva dovrà
implementarle entrambe.

```mermaid
classDiagram

class Event
<<interface>> Event

class AI {
    +registerInputSource(Input)
    +registerView(Output)
    +computeSuggestion(Subject, Event) Suggestion
}
<<interface>> AI

class Output {
    +update(Subject)
}
<<interface>> Output

class Subject
<<interface>> Subject

class Personality
<<interface>> Personality

class Input {
    +getBlocking() Event
}
<<interface>> Input

class GLaDOS {
    -List~Output~ outputs
    -List~Input~ inputs
    -Personality personality 
}

class AbstractSensor {
    +getName() String
}

GLaDOS --|> AI
AI o-- Output
AI o-- Input
GLaDOS o-- Output
GLaDOS o-- Input
Event -- AI
Event -- Input
Subject -- AI
Personality --o GLaDOS 
Personality --o AI
Output -- Subject
AbstractSensor --|> Input
MonitorGui --|> Output
```

Con questa architettura, possono essere aggiunti un numero arbitrario di
input ed output all'intelligenza artificiale. Ovviamente, mentre
l'aggiunta di output è semplice e non richiede alcuna modifica all'IA,
la presenza di nuovi tipi di evento richiede invece in potenza aggiunte
o rifiniture a GLaDOS. Questo è dovuto al fatto che nuovi Input
rappresentano di fatto nuovi elementi della business logic, la cui
alterazione od espansione inevitabilmente impatta il controller del
progetto.

In è esemplificato il diagramma UML architetturale.

## Design dettagliato

### Massimiliano Battelli
Il mio ruolo all'interno del gruppo prevedeva principalmente di sviluppare
la sezione riguardante la gestione dei mazzi, ovvero creazione cancellazione 
e modifica e la relativa GUI. In aggiunta ho implementato la lettura
e il salvataggio di essi nel file JSON.  

**Problema**  Mostrare le carte e i mazzi disponibili, dare la possibilità
all'utente di selezionare le carte e salvarle in un mazzo. I mazzi possono
venire cancellati interagiti per visualizzare le proprie carte.  

**Soluzione** 

In questa sezione si possono approfondire alcuni elementi del design con
maggior dettaglio. Mentre ci attendiamo principalmente (o solo)
interfacce negli schemi UML delle sezioni precedenti, in questa sezione
è necessario scendere in maggior dettaglio presentando la struttura di
alcune sottoparti rilevanti dell'applicazione. È molto importante che,
descrivendo la soluzione ad un problema, quando possibile si mostri che
non si è re-inventata la ruota ma si è applicato un design pattern noto.
Che si sia utilizzato (o riconosciuto) o meno un pattern noto, è
comunque bene definire qual è il problema che si è affrontato, qual è la
soluzione messa in campo, e quali motivazioni l'hanno spinta. È
assolutamente inutile, ed è anzi controproducente, descrivere
classe-per-classe (o peggio ancora metodo-per-metodo) com'è fatto il
vostro software: è un livello di dettaglio proprio della documentazione
dell'API (deducibile dalla Javadoc).

**È necessario che ciascun membro del gruppo abbia una propria sezione
di design dettagliato, di cui sarà il solo responsabile**.

Ciascun
autore dovrà spiegare in modo corretto e giustamente approfondito (non
troppo in dettaglio, non superficialmente) il proprio contributo. È
importante focalizzarsi sulle scelte che hanno un impatto positivo sul
riuso, sull'estensibilità, e sulla chiarezza dell'applicazione.
Esattamente come nessun ingegnere meccanico presenta un solo foglio con
l'intero progetto di una vettura di Formula 1, ma molteplici fogli di
progetto che mostrano a livelli di dettaglio differenti le varie parti
della vettura e le modalità di connessione fra le parti, così ci
aspettiamo che voi, futuri ingegneri informatici, ci presentiate prima
una visione globale del progetto, e via via siate in grado di
dettagliare le singole parti, scartando i componenti che non interessano
quella in esame. Per continuare il parallelo con la vettura di Formula
1, se nei fogli di progetto che mostrano il design delle sospensioni
anteriori appaiono pezzi che appartengono al volante o al turbo, c'è una
chiara indicazione di qualche problema di design.

Si divida la sezione in sottosezioni, e per ogni aspetto di design che
si vuole approfondire, si presenti:

1.  : una breve descrizione in linguaggio naturale del problema che si
    vuole risolvere, se necessario ci si può aiutare con schemi o
    immagini;
2.  : una descrizione della soluzione proposta, analizzando eventuali
    alternative che sono state prese in considerazione, e che descriva
    pro e contro della scelta fatta;
3.  : uno schema UML che aiuti a comprendere la soluzione sopra
    descritta;
4.  : se la soluzione è stata realizzata utilizzando uno o più pattern
    noti, si spieghi come questi sono reificati nel progetto (ad
    esempio: nel caso di Template Method, qual è il metodo template; nel
    caso di Strategy, quale interfaccia del progetto rappresenta la
    strategia, e quali sono le sue implementazioni; nel caso di
    Decorator, qual è la classe astratta che fa da Decorator e quali
    sono le sue implementazioni concrete; eccetera);

La presenza di pattern di progettazione *correttamente utilizzati* è
valutata molto positivamente. L'uso inappropriato è invece valutato
negativamente: a tal proposito, si raccomanda di porre particolare
attenzione all'abuso di Singleton, che, se usato in modo inappropriato,
è di fatto un anti-pattern.

### Elementi positivi

-   Ogni membro del gruppo discute le proprie decisioni di
    progettazione, ed in particolare le azioni volte ad anticipare
    possibili cambiamenti futuri (ad esempio l'aggiunta di una nuova
    funzionalità, o il miglioramento di una esistente).
-   Si mostrano le principali interazioni fra le varie componenti che
    collaborano alla soluzione di un determinato problema.
-   Si identificano, utilizzano *appropriatamente*, e descrivono diversi
    design pattern.
-   Ogni membro del gruppo identifica i pattern utilizzati nella sua
    sottoparte.
-   Si mostrano gli aspetti di design più rilevanti dell'applicazione,
    mettendo in luce la maniera in cui si è costruita la soluzione ai
    problemi descritti nell'analisi.
-   Si tralasciano aspetti strettamente implementativi e quelli non
    rilevanti, non mostrandoli negli schemi UML (ad esempio, campi
    privati) e non descrivendoli.
-   Ciascun elemento di design identificato presenta una piccola
    descrizione del problema calato nell'applicazione, uno schema UML
    che ne mostra la concretizzazione nelle classi del progetto, ed una
    breve descrizione della motivazione per cui tale soluzione è stata
    scelta, specialmente se è stato utilizzato un pattern noto. Ad
    esempio, se si dichiara di aver usato Observer, è necessario
    specificare chi sia l'observable e chi l'observer; se si usa
    Template Method, è necessario indicare quale sia il metodo template;
    se si usa Strategy, è necessario identificare l'interfaccia che
    rappresenta la strategia; e via dicendo.

### Elementi negativi

-   Il design del modello risulta scorrelato dal problema descritto in
    analisi.
-   Si tratta in modo prolisso, classe per classe, il software
    realizzato, o comunque si riduce la sezione ad un mero elenco di
    quanto fatto.
-   Non si presentano schemi UML esemplificativi.
-   Non si individuano design pattern, o si individuano in modo errato
    (si spaccia per design pattern qualcosa che non lo è).
-   Si utilizzano design pattern in modo inopportuno.
-   Si producono schemi UML caotici e difficili da leggere, che
    comprendono inutili elementi di dettaglio.
-   Si presentano schemi UML con classi (nel senso UML del termine) che
    "galleggiano" nello schema, non connesse, ossia senza relazioni con
    il resto degli elementi inseriti.
-   Si tratta in modo inutilmente prolisso la divisione in package,
    elencando ad esempio le classi una per una.

### Esempio minimale (e quindi parziale) di sezione di progetto con UML ben realizzati

#### Personalità intercambiabili

Rappresentazione UML del pattern Strategy per la personalità di
GLaDOS

```mermaid
classDiagram

class Personality {
    onSuccess()
}
<<interface>> Personality

class AbstractPersonality {
    +onSuccess()
}
<<abstract>> AbstractPersonality

class AI {
    +setPersonality(Personality)
}
<<interface>> AI

AbstractPersonality --|> Personality
Personality -- AI
Good --|> AbstractPersonality
Evil --|> AbstractPersonality

```

##### Problema

GLaDOS ha più personalità intercambiabili, la cui presenza deve essere
trasparente al client.

##### Soluzione

Il sistema per la gestione della personalità utilizza il *pattern
Strategy*, come da : le implementazioni di `Personality` possono essere
modificate, e la modifica impatta direttamente sul comportamento di
GLaDOS.

#### Riuso del codice delle personalità

Rappresentazione UML dell'applicazione del pattern Template Method
alla gerarchia delle Personalità

```mermaid
classDiagram

class AbstractPersonality {
    #makeCake() Cake
    +onSuccess()
}
<<abstract>> AbstractPersonality

class Good {
    #makeCake() Cake
}

class Evil {
    #makeCake() Cake
}

Good --|> AbstractPersonality
Evil --|> AbstractPersonality
```

##### Problema

In fase di sviluppo, sono state sviluppate due personalità, una buona ed
una cattiva. Quella buona restituisce sempre una torta vera, mentre
quella cattiva restituisce sempre la promessa di una torta che verrà in
realtà disattesa. Ci si è accorti che diverse personalità condividevano
molto del comportamento, portando a classi molto simili e a
duplicazione.

##### Soluzione

Dato che le due personalità differiscono solo per il comportamento da
effettuarsi in caso di percorso completato con successo, è stato
utilizzato il *pattern template method* per massimizzare il riuso, come
da . Il metodo template è `onSuccess()`, che chiama un metodo astratto e
protetto `makeCake()`.

#### Gestione di output multipli

Il pattern Observer è usato per consentire a GLaDOS di informare tutti
i sistemi di output in ascolto.

```mermaid
classDiagram

class Output {
    +update(Subject)
}
class GLaDOS {
    -List~Output~ outputs
}
MonitorGui --|> Output
Logger --|> Output
GLaDOS o-- Output

```

##### Problema

Il sistema deve supportare output multipli. In particolare, si richiede
che vi sia un logger che stampa a terminale o su file, e un'interfaccia
grafica che mostri una rappresentazione grafica del sistema.

##### Soluzione

Dato che i due sistemi di reporting utilizzano le medesime informazioni,
si è deciso di raggrupparli dietro l'interfaccia `Output`. A questo
punto, le due possibilità erano quelle di far sì che `GLaDOS` potesse
pilotarle entrambe. Invece di fare un sistema in cui questi output sono
obbligatori e connessi, si è deciso di usare maggior flessibilità (anche
in vista di future estensioni) e di adottare una comunicazione
uno-a-molti fra `GLaDOS` ed i sistemi di output. La scelta è quindi
ricaduta sul *pattern Observer*: `GLaDOS` è observable, e le istanze di
`Output` sono observer. Il suo utilizzo è esemplificato in

### Contro-esempio: pessimo diagramma UML 

![badarch](https://user-images.githubusercontent.com/1991673/207835689-932d3c09-cd0b-4144-a34b-20974a6bcf1c.jpg)

Qui sopra è mostrato il modo **sbagliato** di fare le cose. Questo schema è
fatto male perché:
-   È caotico.
-   È difficile da leggere e capire.
-   Vi sono troppe classi, e non si capisce bene quali siano i rapporti
    che intercorrono fra loro.
-   Si mostrano elementi implementativi irrilevanti, come i campi e i
    metodi privati nella classe `AbstractEnvironment`.
-   Se l'intenzione era quella di costruire un diagramma architetturale,
    allora lo schema è ancora più sbagliato, perché mostra pezzi di
    implementazione.
-   Una delle classi, in alto al centro, galleggia nello schema, non
    connessa a nessuna altra classe, e di fatto costituisce da sola un
    secondo schema UML scorrelato al resto
-   Le interfacce presentano tutti i metodi e non una selezione che
    aiuti il lettore a capire quale parte del sistema si vuol mostrare.

# Sviluppo

## Testing automatizzato

Il testing automatizzato è un requisito di qualunque progetto software
che si rispetti, e consente di verificare che non vi siano regressioni
nelle funzionalità a fronte di aggiornamenti.
Per quanto riguarda questo
progetto è considerato sufficiente un test minimale, a patto che sia
completamente automatico. Test che richiedono l'intervento da parte
dell'utente sono considerati *negativamente* nel computo del punteggio
finale.

### Elementi positivi

-   Si descrivono molto brevemente i componenti che si è deciso di
    sottoporre a test automatizzato.
-   Si utilizzano suite specifiche (e.g. JUnit) per il testing
    automatico.

### Elementi negativi {#elementi-negativi-4 .unnumbered}

-   Non si realizza alcun test automatico.
-   La non presenza di testing viene aggravata dall'adduzione di
    motivazioni non valide. Ad esempio, si scrive che l'interfaccia
    grafica non è testata automaticamente perché è *impossibile*
    farlo (testare in modo automatico le interfacce grafiche è possibile, si veda, come esempio,
    [TestFX](https://github.com/TestFX/TestFX);
    semplicemente, nel corso non c'è modo e tempo di introdurvi questo
    livello di complessità).
-   Si descrive un testing di tipo manuale in maniera prolissa.
-   Si descrivono test effettuati manualmente che sarebbero potuti
    essere automatizzati, ad esempio scrivendo che si è usata
    l'applicazione manualmente.
-   Si descrivono test non presenti nei sorgenti del progetto.
-   I test, quando eseguiti, falliscono.

## Note di sviluppo

Questa sezione, come quella riguardante il design dettagliato va svolta
**singolarmente da ogni membro del gruppo**.

Ciascuno dovrà mettere in
evidenza da un minimo di 3 ad un massimo di 5 punti in cui ritiene di aver scritto codice particolarmente ben congegnato,
ad esempio perché sfrutta una libreria o feature avanzata non vista a lezione,
oppure perché usa costrutti del linguaggio avanzati.

Ciascun elemento deve presentare:
1. Nome del sorgente dove reperirlo, a scelta uno fra:
   * nome qualificato della classe
   * percorso del file
   * permalink GitHub
2. Uno snippet con il codice cui ci si riferisce
3. Una *brevissima* descrizione della feature avanzata che si vuole mostrare.

Esempi di feature interessanti potrebbero essere:
- Progettazione con generici, ad esempio costruzione di nuovi tipi
  generici, e uso di generici bounded.
- Uso di lambda expressions
- Uso di `Stream`, di `Optional` o di altri costrutti funzionali
- Uso della reflection
- Definizione ed uso di nuove annotazioni
- Uso del Java Platform Module System
- Uso di parti della libreria JDK non spiegate a lezione
  (networking, compressione, parsing XML, eccetera)
- Uso di librerie di terze parti: JavaFX, Google Guava, Apache Commons...
- Sviluppo di algoritmi particolarmente interessanti
  *non forniti da alcuna libreria*
  (spesso può convenirvi chiedere sul forum se ci sia
  una libreria per fare una certa cosa, prima di gettarvi a capofitto
  per scriverla voi stessi).

In questa sezione, *dopo l'elenco*, vanno menzionati ed attributi con
precisione eventuali pezzi di codice "riadattati" (o scopiazzati...) da
Internet o da altri progetti, pratica che tolleriamo ma che non
raccomandiamo.
Si rammenta agli studenti che non è consentito partire da
progetti esistenti e procedere per modifiche successive.
Si ricorda
anche che i docenti hanno in mano strumenti antiplagio piuttosto
raffinati e che "capiscono" il codice e la storia delle modifiche del
progetto, per cui tecniche banali come cambiare nomi (di classi, metodi,
campi, parametri, o variabili locali), aggiungere o togliere commenti,
oppure riordinare i membri di una classe vengono individuate senza
problemi.
Le regole del progetto spiegano in dettaglio l'approccio dei
docenti verso atti gravi come il plagiarismo.

I pattern di design **non** vanno messi qui. L'uso di pattern di design
(come suggerisce il nome) è un aspetto avanzato di design, non di
implementazione, e non va in questa sezione.

### Elementi positivi

- Ogni studente ha almeno 3 sottosezioni con snippet e descrizione
- Nessuno studente ha più di 5 sottosezioni con snippet e descrizione
- Si identificano parti di codice prese da altri progetti, dal web, o
comunque scritte in forma originale da altre persone. In tal senso,
si ricorda che agli ingegneri non è richiesto di re-inventare la
ruota continuamente: se si cita debitamente la sorgente è tollerato
fare uso di di snippet di codice open source per risolvere
velocemente problemi non banali. Nel caso in cui si usino snippet di
codice di qualità discutibile, oltre a menzionarne l'autore
originale si invitano gli studenti ad adeguare tali parti di codice
agli standard e allo stile del progetto. Contestualmente, si fa
presente che è largamente meglio fare uso di una libreria che
copiarsi pezzi di codice: qualora vi sia scelta (e tipicamente c'è),
si preferisca la prima via.

### Elementi negativi
- Si elencano applicazioni di terze parti
  (peggio se per usarle occorre licenza, e lo studente ne è sprovvisto)
  che non c'entrano nulla con lo sviluppo, ad esempio:
    -   Editor di grafica vettoriale come Inkscape o Adobe Illustrator;
    -   Editor di grafica scalare come GIMP o Adobe Photoshop;
    -   Editor di audio come Audacity;
    -   Strumenti di design dell'interfaccia grafica come SceneBuilder:
        il codice è in ogni caso inteso come sviluppato da voi.
- Si descrivono aspetti di scarsa rilevanza, o si scende in dettagli inutili.
- Sono presenti parti di codice sviluppate originalmente da altri che
non vengono debitamente segnalate. In tal senso, si ricorda agli
studenti che i docenti hanno accesso a tutti i progetti degli anni
passati, a Stack Overflow, ai principali blog di sviluppatori ed
esperti Java, ai blog dedicati allo sviluppo di soluzioni e
applicazioni (inclusi blog dedicati ad Android e allo sviluppo di
videogame), nonché ai vari GitHub, GitLab, e Bitbucket.
Conseguentemente, è *molto* conveniente *citare* una fonte ed usarla
invece di tentare di spacciare per proprio il lavoro di altri.
- Si elencano design pattern

### Esempio

#### Utilizzo della libreria SLF4J

**Dove**: diverse classi, ad esempio `it.unibo.alchemist.boundary.swingui.effect.impl.EffectBuilder`

**Permalink**: https://github.com/AlchemistSimulator/Alchemist/blob/5c17f8b76920c78d955d478864ac1f11508ed9ad/alchemist-swingui/src/main/java/it/unibo/alchemist/boundary/swingui/effect/impl/EffectBuilder.java#L49

**Snippet**

```java
    private static final Logger L = LoggerFactory.getLogger(EffectBuilder.class);
...
        try {
            barrier.await();
        } catch (final InterruptedException e) {
            L.error("Bug in " + getClass(), e);
        }
...
}
```

#### Utilizzo della `LoadingCache` di Google Guava

**Dove**: `it.unibo.alchemist.protelis.AlchemistExecutionContext`

**Permalink**: https://github.com/AlchemistSimulator/Alchemist/blob/d8a1799027d7d685569e15316a32e6394632ce71/alchemist-incarnation-protelis/src/main/java/it/unibo/alchemist/protelis/AlchemistExecutionContext.java#L63-L79

**Snippet**

```java
private final LoadingCache<P, Double> cache = CacheBuilder.newBuilder()
    .expireAfterAccess(10, TimeUnit.MINUTES)
    .maximumSize(100)
    .build(new CacheLoader<>() {
        @Nonnull
        @Override
        public Double load(@Nonnull final P dest) {
        if (environment instanceof MapEnvironment) {
            if (dest instanceof GeoPosition) {
                return ((MapEnvironment<Object, ?, ?>) environment).computeRoute(node, (GeoPosition) dest).length();
            } else {
                throw new IllegalStateException("Illegal position type: " + dest.getClass() + " " + dest);
            }
        }
        return getDevicePosition().distanceTo(dest);
    }
});
```

#### Scrittura di metodo generico con parametri contravarianti

**Dove**: `it.unibo.alchemist.protelis.AlchemistExecutionContext`

**Permalink**: https://github.com/AlchemistSimulator/Alchemist/blob/d8a1799027d7d685569e15316a32e6394632ce71/alchemist-incarnation-protelis/src/main/java/it/unibo/alchemist/protelis/AlchemistExecutionContext.java#L141-L143

**Snippet**
```java
private <X> Field<X> buildFieldWithPosition(final Function<? super P, X> fun) {
    return buildField(fun, getDevicePosition());
}
```

#### Utilizzo della libreria `Stream` e di lambda expressions

**Dove**: molte classi, ad esempio `it.unibo.alchemist.model.ProtelisIncarnation`

**Permalink**: https://github.com/AlchemistSimulator/Alchemist/blob/d8a1799027d7d685569e15316a32e6394632ce71/alchemist-incarnation-protelis/src/main/java/it/unibo/alchemist/model/ProtelisIncarnation.java#L98-L120

**Snippet**
```java
@Nonnull
private static List<RunProtelisProgram<?>> getIncomplete(
    final Node<?> protelisNode,
    final List<RunProtelisProgram<?>> alreadyDone
) {
    return protelisNode.getReactions().stream()
        /*
        * Get the actions
        */
        .flatMap(r -> r.getActions().stream())
        /*
        * Get only the ProtelisPrograms
        */
        .filter(a -> a instanceof RunProtelisProgram)
        .map(a -> (RunProtelisProgram<?>) a)
        /*
        * Retain only those ProtelisPrograms that have no associated ComputationalRoundComplete.
        *
        * Only one should be available.
        */
        .filter(prog -> !alreadyDone.contains(prog))
        .collect(Collectors.toList());
}
```

#### Protezione da corse critiche usando `Semaphore`

**Dove**: `it.unibo.alchemist.model.ProtelisIncarnation.DummyContext`

**Permalink**: https://github.com/AlchemistSimulator/Alchemist/blob/d8a1799027d7d685569e15316a32e6394632ce71/alchemist-incarnation-protelis/src/main/java/it/unibo/alchemist/model/ProtelisIncarnation.java#L388-L440

**Snippet**

```java
private static final Semaphore MUTEX = new Semaphore(1);
private static final int SEED = -241_837_578;
private static final RandomGenerator RNG = new MersenneTwister(SEED);
...
@Override
public double nextRandomDouble() {
    final double result;
    MUTEX.acquireUninterruptibly();
    result = RNG.nextDouble();
    MUTEX.release();
    return result;
}
```

# Commenti finali

In quest'ultimo capitolo si tirano le somme del lavoro svolto e si
delineano eventuali sviluppi futuri.

**Nessuna delle informazioni incluse in questo capitolo verrà utilizzata
per formulare la valutazione finale**, a meno che non sia assente o
manchino delle sezioni obbligatorie. Al fine di evitare pregiudizi
involontari, l'intero capitolo verrà letto dai docenti solo dopo aver
formulato la valutazione.

## Autovalutazione e lavori futuri

**È richiesta una sezione per ciascun membro del gruppo,
obbligatoriamente**.

Ciascuno dovrà autovalutare il proprio lavoro,
elencando i punti di forza e di debolezza in quanto prodotto. Si dovrà
anche cercare di descrivere *in modo quanto più obiettivo possibile* il
proprio ruolo all'interno del gruppo. Si ricorda, a tal proposito, che
ciascuno studente è responsabile solo della propria sezione: non è un
problema se ci sono opinioni contrastanti, a patto che rispecchino
effettivamente l'opinione di chi le scrive.

## Difficoltà incontrate e commenti per i docenti

Questa sezione, **opzionale**, può essere utilizzata per segnalare ai
docenti eventuali problemi o difficoltà incontrate nel corso o nello
svolgimento del progetto, può essere vista come una seconda possibilità
di valutare il corso (dopo quella offerta dalle rilevazioni della
didattica) avendo anche conoscenza delle modalità e delle difficoltà
collegate all'esame, cosa impossibile da fare usando le valutazioni in
aula per ovvie ragioni. È possibile che alcuni dei commenti forniti
vengano utilizzati per migliorare il corso in futuro: sebbene non andrà
a vostro beneficio, potreste fare un favore ai vostri futuri colleghi.
Ovviamente **il contenuto della sezione non impatterà il voto finale**.

# Guida utente

Fare riferimento al file README.md

### Elementi positivi

-   Si istruisce in modo semplice l'utente sull'uso dell'applicazione,
    eventualmente facendo uso di schermate e descrizioni.

### Elementi negativi

-   Si descrivono in modo eccessivamente minuzioso tutte le
    caratteristiche, anche minori, del software in oggetto.
-   Manca una descrizione che consenta ad un utente qualunque di
    utilizzare almeno le funzionalità primarie dell'applicativo.
