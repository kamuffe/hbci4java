## Vorab

Dies ist ein Fork von [HBCI4Java](https://github.com/hbci4j/hbci4java). Die Wichtigste Änderung besteht darin HBCI4Java auch gefahrlos in Webanwendungen zu verwenden OHNE die statischen Initialisierungs und Aufräum operationen.


## Änderungen/Erweiterungen 



- static Umbau der HBCIUtils und HBCIUtilsInternal um HBCI4Java auch in Webanwendungen einsetzen zu können (u.a. entfernen der ThreadPool Logik)
  So wird jedesmal wenn ein Handle erzeugt wird eine neue Instanz von HBCIHandler, HBCIKernel, HBCIPassport und HBCICallback erzeugt, die nicht in andere Threads geshared werden.
- Logging basierend auf slf4j
- Passports werden direkt über den Konstruktoraufruf erzeugt und nicht über eine Methode mit String parameter am Handler. Das ist einfacher für den Entwickler da Fehler bereits zur Compilezeit erkannt werden.
- Verarltete Logik basierend auf Arrays umgebaut auf generische Listen


## Ausstehende Arbeiten 
- locking der passport datei wenn multithreaded lesend/schreibend darauf zugegriffen wird
- Filtering der log Ausgaben von sensiblen Daten
- weiteres refactoring (private member variablen statt public, lists vs. arrays, doppelten code entfernen => rewriters, kapselung verbessern)


## Selbst compilieren

Du benötigst:

- GIT (https://git-scm.com/)
- Java SDK 8 oder höher (http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- Apache Maven 3.3.9 oder höher (https://maven.apache.org/)

Öffne ein Terminal-Fenster und checke den Quellcode per GIT aus:

    $> git clone https://github.com/hbci4j/hbci4java.git
    
Wechsle in den Ordner "hbci4java":

    $> cd hbci4java

Erzeuge die JAR-Datei per:

    $> mvn package
  
Im Ordner "target" wird die Datei "hbci4j-core-${version}.jar" erzeugt.

## Import in Eclipse

Du benötigst:

- Eine Eclipse-Version mit Maven-Support, z.Bsp.: "Eclipse IDE for Java EE Developers" (http://www.eclipse.org/downloads/eclipse-packages/) 
- Den ausgecheckten Quellcode von HBCI4Java per GIT (siehe oben)

Klicke im Menu von Eclipse auf "File->Import..." und wähle "Maven->Existing Maven Projects". Folge den Anweisungen des Assistenten. Klicke anschließend mit der rechten Maustaste im "Package Explorer" oder "Navigator" auf das Projekt und wähle im Contextmenu "Maven->Update Project...".


## Unit-Tests
Im Ordner "src/main/test/" befinden sich einige JUnit-Tests. Einige davon erfordern jedoch das Vorhandensein spezieller Testumgebungen (Vorhandensein von Bankzugängen oder Chipkartenleser). Diese Tests werden im Zuge der Erstellung von Deployment-Artefakten nur dann ausgeführt, wenn die entsprechenden System-Properties "test.online=true" und "test.chipcard=true" aktiv sind. Die Tests zur Ausführung von HBCI-Geschäftsvorfällen benötigen jedoch weitere Daten (Empfängerkonto, Betrag, Verwendungszweck, usw.). Wenn du diese Tests ausführen möchtest, schaue dir den Quellcode der entsprechenden Tests an.

## Beispiel-Code

Unter https://github.com/hbci4j/hbci4java/blob/master/src/main/java/org/kapott/hbci/examples/UmsatzAbrufPinTan.java findest du Beispiel-Code zum Abrufen des Saldos und der Umsätze eines Kontos per PIN/TAN-Verfahren.
 
