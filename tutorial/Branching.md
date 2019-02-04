# Branching

In Git Bash and in SourceTree

Větvení znamená, že se můžete odloučit od hlavní linie vývoje a pokračovat v práci, 
aniž byste do hlavní linie zasahovali. Git neukládá data jako sérii změn nebo rozdílů, 
ale jako sérii snímků. Tento snímek / objekt obsahuje jméno a e-mail autora, 
zprávu  a odkazy na jeden nebo víc objektů revize, které této revizi přímo předcházely (jeho rodiče): na žádného rodiče pro počáteční revizi, na jednoho rodiče pro běžnou revizi a na více rodičů pro revizi, která je výsledkem sloučení dvou nebo více větví.

Dosud jsme pracovali jen s jednou  větví, říkali jsme jí _master_ (vzniká při `git init`, 
její název není nutné měnit). Nyní vytvoříme novou větev. Proč ? I když kod vyvíjí jednotlivec, 
je velmi bezpečné vyvíjet všechny nové funkce/opravy na vlastních větvích a přitom mít 
v hlavní větvi - _masteru_ - zachovaný funkční kód.

Jakmile pracujete v týmu, je používání větví naprosto nezbytnou záležitostí: 
jen tak má totiž každý vývojář jistotu, že nepřepisuje kód někomu jinému. 
Vytvoření nové větve znamená vytvoření nového ukazatele na aktuální revizi.
  
## New branch
Novou větev vytvoříme příkazem
 
`git branch <branch-name>`

Abychom v tomto místě mohli odklonit svoji práci, 
musíme se do nové větve přepnout. 
To provedeme příkazem `checkout`.  

`git checkout <branch-name>`

_Pozn.: Pokud jsou v aktuálním pracovní větvi změněné, ale neuložené soubory, 
git vypíše varování a přepnutí na jinou větev neprovede_
 
V nové větvi provedeme změny v kodu a potvrdíme je commitem.

`git commit -a`  
 
Přepneme do větve master `git checkout fix`, provedeme změny v kódu, např. přidáme soubor, 
potvrdíme změnu a zřetelně vidíme větvení.
Seznam všech větví v repositáři vypíšeme příkazem 
  
`git branch`

**Example in Git Bash:**  
_Repository for example: NewBranchStart.zip_

1. Create new branch, name it _fix_ 
2. Switch to the new branch
3. Make changes in code
4. Commit changes
5. Look at the result, list of all branches

<details>
  <summary>Click here for solution </summary>
    
  1. `git branch fix`  
  2. `git checkout fix`
  3. Changes in code
  4. `git commit -a`
  5. `git branch`  
</details>  
</br>

**Do the some in SourceTree.**   
_Remove NewBranch folder from repository and unpack NewBranchStart.zip and copy again._

Result is:

![NewBranch](images/NewBranch.JPG)

## Merge

Výpisem větví `git branch` zjistíme, že práce rozdělila. 
Změny provedené v obou větvích nyní chceme spojit do jedné. Větev _fix_ vložíme / připojíme do větve _master_ 
příkazem `merge`. Jmenovaná větev se spojí s větví, ve které se právě nacházíme.
 
`git merge <branch-name>`

**Example in Git Bash:**  
_Repository for example: MergeStart.zip_

1. Join _fix_ branch to _master_.
2. Look at the result, list of all branches

<details>
  <summary>Click here for solution</summary>
    
  1. `git checkout master`
  1. `git merge fix`    
  2. `git branch`    
</details>  
</br>

**Do the some in SourceTree.**  
_Remove Merge folder from repository and unpack MergeStart.zip and copy again._   

Result is:

![Merge](images/Merge.JPG)

## Set extern merge tool in SourceTree

1. Download from _https://sourcegear.com/diffmerge/downloads.php_ .  
2. Install.  
3. Set in SourceTree menu - Options / Diff 

![ExternMergeTool.jpg](images/ExternMergeTool.jpg)

## Merge with conflict

Lets have two branches and made different changes in both in the some place.  
Now merge them.

`git merge <branch-name>` 

We got the message about merge conflict. It looks like this:
  
`...`  
`_Auto-merging Main.java_`  
_`CONFLICT (content): Merge conflict in Main.java`_   
_`Automatic merge failed; fix conflicts and then commit the result._`_

Git makes notes, marks the places of the conflict in the files. It looks like this:
  
_File Main.java:_  

_`<<<<<<< HEAD`_  
_Guest guest3 = new Guest("Orel", "yestarday", "Nor" );_  
_=======_  
_Guest guest3 = new Guest("Orel", "yestarday", "Dan" );_  
_.>>>>>>> fix_

You have to fix changes manualy, save file and commit.   

`git commit -a`

Notepad++ (or other tool you set before) is opened. Update merge message, save file and close Notepad++ .

**Example in Git Bash:**  
_Repository for example: MergeConfictStart.zip_

1. Join _fix_ branch to _master_.
3. Resolve merge conflict.
2. Look at the result, list of all branches.

<details>
  <summary>Click here for solution </summary>
    
  1. `git checkout master`
  2. `git merge fix` Merge conflict message is shown.
  3. Change Main.java file and save it.
  4. `git commit -a`  
  5. Extern editor is opened. Edit ( or not ) commit message, save file and close editor.  
  6. Message about suceessfull merging is shown. Similar like this :  
     _Merge branch 'fix'.Resolved conflict in Main.java_      
</details>  


**Do the some in SourceTree.**  
_Remove MergeConfict folder from repository and unpack MergeConfictStart.zip and copy again._ 

1. On branch master / Merge /  select branch-commit which  has to be merged / OK
2. Megre conflict message window is shown. 
3. Close it. In stage / unstage section are shown files with conflict. Right click 
on file, choose Resolve conflict / Launch External Tool. External merge tool window is opened. 
![DiffMergeFile.jpg](images/DiffMergeFile.jpg)
4. Make changes, save and close Diff merge.
5. Commit / update message / ok

Result is:  
![MergeWithConflict](images/MergeWithConflict.JPG)

## Rebase  (přeskládání)  

Rozdíl mezi merge a rebase
 
 Merge   
 ![SchemaMerge](images/SchemaMerge.jpg)


 Rebase  
 ![SchemaRebase](images/SchemaRebase.jpg)

Příkazem `rebase` vezmete všechny změny, které byly zapsány v jedné větvi
a necháte je přehrát na jinou větev. 
Používá se pokud byla větev, ve které se provedly změny, 
oddělena z jiné větve (zpravidla _master_) před delší dobou, takže v původní větvi došlo ke změnám, 
můžeme chtít místo viditelného sloučení větví aplikovat změny ze své větve 
do hlavní větve.

Ve konečném výsledku  není žádný rozdíl mezi merge a rebase. Výsledkem rebase je však čistší historie.
Příkaz pro přeskládání je 

`git rebase <branch-name>`  

Dojde-li ke konfliktu, podobně jako v předchozím případě při `merge`, opět provedeme manuálně 
opravu souboru, přidáme opravený soubor do oblasti připravovaných změn

`git add <file-name>`

a potvrdíme ukočení příkazu rebase

`git rebase --continue`  

**Example in Git Bash:**  
_Repository for example: RebaseWithConflict.zip_

1. Rebase branch _fix_ on branch _master_
2. Look at the result, list of all branches.

<details>
  <summary>Click here for solution </summary>
    
  1. `git checkout fix`
  2. `git rebase fix` Merge conflict message is shown.
  3. Change Main.java file and save it.
  4. `git add Main.java`
  5. `git rebase --continue` 
  6. `git branch` 
</details>  

**Do the some in SourceTree.**  
_Repository for example: RebaseWithConflictStart.zip_ 

1. Right click on master / Rebase current changes onto master  
![RebaseStart](images/RebaseStart.jpg)
 Merge conflict message is shown.
2. Resolve conflict with extern tool (use same steps as in the case merge-conflict,) 
3. Finally click to “uncommitted changes”
4. In main menu click Action / Continue rebase. 
 
 Result is:  
![RebaseEnd](images/RebaseEnd.jpg)
  
## Delete branch

používáme zpravidla ve chvíli, kdy již větev nebudeme nadále potřebovat, protože jsme ji zmergovali.  
Ke smazání větve slouží atribut `–d`.  
 
 `git branch –d <branch_name>`

Pokud větev nebyla namergovaná do jiné větve, příkaz vypíše varování a větev nezruší. 
Pokud chceme větev opravdu zrušit, použijeme parametr (velké) `-D`.

**Example in Git Bash:**  
_Repository for example: MergeStart.zip_

1. List all branches
2. Remove branch _fix_
3. List all branches

<details>
  <summary>Click here for solution </summary>
    
  1. `git branch`
  2. `git branch -d fix` 
  3. `git branch -D fix`
  4. `git branch`

</details> 


**Do the some in SourceTree.**   
_Repository for example: Merge.zip_

Result is:  
![DeleteBranch](images/DeleteBranch.jpg)
