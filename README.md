**…or create a new repository on the command line**
```shell
echo "# JavaWebBasic" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/jokerhunter/JavaWebBasic.git
git push -u origin main
```
**…or push an existing repository from the command line**
```shell
git remote add origin https://github.com/jokerhunter/JavaWebBasic.git
git branch -M main
git push -u origin main
```
**…or import code from another repository**
You can initialize this repository with code from a Subversion, Mercurial, or TFS project.