To remove the `.idea` folder (IntelliJ project config) from your Git repository, follow these steps:

---

## ✅ Step 1: Remove from Git (but keep locally)

```bash
git rm -r --cached .idea
```

👉 This removes `.idea` from the repository but **keeps it on your system**.

---

## ✅ Step 2: Add to `.gitignore`

Open (or create) `.gitignore` and add:

```
.idea/
```

---

## ✅ Step 3: Commit the changes

```bash
git add .gitignore
git commit -m "Remove .idea folder from repository"
```

---

## ✅ Step 4: Push to remote

```bash
git push
```

---

## 🔥 Important Notes

* `.idea` contains **local IDE settings** → should not be shared
* Always ignore IDE files (`.idea`, `.vscode`, etc.)
* This is a **common interview / best practice question**

---

## 🚀 Bonus (Clean setup for Java projects)

Your `.gitignore` should include:

```
.idea/
*.iml
target/
build/
out/
```

---

If you want, I can give you a **perfect `.gitignore` for Maven/Gradle + Playwright + TestNG** 👍
