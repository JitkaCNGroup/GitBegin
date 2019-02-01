# Branching

In Git Bash and in SourceTree

V�tven� znamen�, �e se m��ete odlou�it od hlavn� linie v�voje a pokra�ovat v pr�ci, 
ani� byste do hlavn� linie zasahovali. Git neukl�d� data jako s�rii zm�n nebo rozd�l�, 
ale jako s�rii sn�mk�. Tento sn�mek / objekt obsahuje jm�no a e-mail autora, 
zpr�vu  a odkazy na jeden nebo v�c objekt� revize, kter� t�to revizi p��mo p�edch�zely (jeho rodi�e): na ��dn�ho rodi�e pro po��te�n� revizi, na jednoho rodi�e pro b�nou revizi a na v�ce rodi�� pro revizi, kter� je v�sledkem slou�en� dvou nebo v�ce v�tv�.

Dosud jsme pracovali jen s jednou  v�tv�, ��kali jsme j� _master_ (vznik� p�i `git init`, 
jej� n�zev nen� nutn� m�nit). Nyn� vytvo��me novou v�tev. Pro� ? I kdy� kod vyv�j� jednotlivec, 
je velmi bezpe�n� vyv�jet v�echny nov� funkce/opravy na vlastn�ch v�tv�ch a p�itom m�t 
v hlavn� v�tvi - _masteru_ - zachovan� funk�n� k�d.

Jakmile pracujete v t�mu, je pou��v�n� v�tv� naprosto nezbytnou z�le�itost�: 
jen tak m� toti� ka�d� v�voj�� jistotu, �e nep�episuje k�d n�komu jin�mu. 
Vytvo�en� nov� v�tve znamen� vytvo�en� nov�ho ukazatele na aktu�ln� revizi.
  
## New branch
Novou v�tev vytvo��me p��kazem
 
`git branch <branch-name>`

Abychom v tomto m�st� mohli odklonit svoji pr�ci, 
mus�me se do nov� v�tve p�epnout. 
To provedeme p��kazem `checkout`.  

`git checkout <branch-name>`

_Pozn.: Pokud jsou v aktu�ln�m pracovn� v�tvi zm�n�n�, ale neulo�en� soubory, 
git vyp�e varov�n� a p�epnut� na jinou v�tev neprovede_
 
V nov� v�tvi provedeme zm�ny v kodu a potvrd�me je commitem.

`git commit -a`  
 
P�epneme do v�tve master `git checkout fix`, provedeme zm�ny v k�du, nap�. p�id�me soubor, 
potvrd�me zm�nu a z�eteln� vid�me v�tven�.
Seznam v�ech v�tv� v reposit��i vyp�eme p��kazem 
  
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

V�pisem v�tv� `git branch` zjist�me, �e pr�ce rozd�lila. 
Zm�ny proveden� v obou v�tv�ch nyn� chceme spojit do jedn�. V�tev _fix_ vlo��me / p�ipoj�me do v�tve _master_ 
p��kazem `merge`. Jmenovan� v�tev se spoj� s v�tv�, ve kter� se pr�v� nach�z�me.
 
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

## Rebase  (p�eskl�d�n�)  

Rozd�l mezi merge a rebase
 
 Merge   
 ![SchemaMerge](images/SchemaMerge.jpg)


 Rebase  
 ![SchemaRebase](images/SchemaRebase.jpg)

P��kazem `rebase` vezmete v�echny zm�ny, kter� byly zaps�ny v jedn� v�tvi
a nech�te je p�ehr�t na jinou v�tev. 
Pou��v� se pokud byla v�tev, ve kter� se provedly zm�ny, 
odd�lena z jin� v�tve (zpravidla _master_) p�ed del�� dobou, tak�e v p�vodn� v�tvi do�lo ke zm�n�m, 
m��eme cht�t m�sto viditeln�ho slou�en� v�tv� aplikovat zm�ny ze sv� v�tve 
do hlavn� v�tve.

Ve kone�n�m v�sledku  nen� ��dn� rozd�l mezi merge a rebase. V�sledkem rebase je v�ak �ist�� historie.
P��kaz pro p�eskl�d�n� je 

`git rebase <branch-name>`  

Dojde-li ke konfliktu, podobn� jako v p�edchoz�m p��pad� p�i `merge`, op�t provedeme manu�ln� 
opravu souboru, p�id�me opraven� soubor do oblasti p�ipravovan�ch zm�n

`git add <changed-file>`

a potvrd�me uko�en� p��kazu rebase

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
 Merge conflict message is shown
2. Resolve conflict with extern tool (some path as in merge was) 
3. Finally click to �uncommitted changes�
4. In main menu click Action / Continue rebase. 
 
 Result is:  
![RebaseEnd](images/RebaseEnd.jpg)
  
## Delete branch

pou��v�me zpravidla ve chv�li, kdy ji� v�tev nebudeme nad�le pot�ebovat, proto�e jsme ji zmergovali.  
Ke smaz�n� v�tve slou�� atribut `�d`.  
 
 `git branch �d <branch_name>`

Pokud v�tev nebyla namergovan� do jin� v�tve, p��kaz vyp�e varov�n� a v�tev nezru��. 
Pokud chceme v�tev opravdu zru�it, pou�ijeme parametr (velk�) `-D`.

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
