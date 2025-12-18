# Copilot / AI Agent Instructions — vite-project

Quick context
- Small Vite + React app used for learning/demo. Entry: `src/main.jsx` → `src/App.jsx`.
- Components live in `src/components/`. Two styles are shown: class-based (`src/components/ClassBasedProps`) and functional (`src/components/FuncGetting`).
- Static assets: `public/` and `src/assets/`.

How to run (important)
- Install deps: `npm install`
- Dev server: `npm run dev` (Vite)
- Build: `npm run build`
- Preview build: `npm run preview`
- Lint: `npm run lint` (project uses the provided `eslint.config.js`)

What to change and how
- Add presentational components under `src/components/`. Use PascalCase filenames (e.g. `GreetingClass.jsx`, `MyWidget.jsx`).
- Data-only modules (static arrays) live as simple JS modules, e.g. `src/components/ClassBasedProps/DataHolder.js` exports default array used by `App.jsx`.
- Parent-to-child data flow: `App.jsx` maps data and passes props to children (see `GreetingClass` usage). Follow this pattern rather than reading globals.
- Prefer small focused components: App composes children and maps arrays to components with `key` props.

Conventions found in this repo
- File extensions: mostly `.jsx`, one `.tsx` exists — treat TypeScript files as isolated typed components if encountered.
- Component export style: default exports (e.g. `export default function ...` or `export default class ...`) — follow the existing default-export pattern.
- ESLint configuration uses modern rules in `eslint.config.js`. Avoid unused variables unless the name starts with an uppercase or underscore (see rule in config).

Files to inspect for context/examples
- `src/App.jsx` — shows data mapping and component composition.
- `src/components/ClassBasedProps/GreetingClass.jsx` — class-based component example and inline comments about props.
- `src/components/ClassBasedProps/DataHolder.js` — static data array used by `App.jsx`.
- `src/main.jsx`, `vite.config.js`, `package.json`, `eslint.config.js` — runtime and tooling setup.

Small, actionable editing notes for AI
- When adding imports, use relative paths from the file location (e.g. `./components/...` from `src/App.jsx`).
- Preserve default exports for new components to match current imports.
- When changing data shapes, update both `DataHolder.js` and any component prop destructuring (e.g. `const { name, role, age } = props`).
- If adding tests or scripts, prefer adding npm scripts to `package.json` and avoid changing Vite plugin setup unless necessary.

Troubleshooting file/creation issues (for humans and AI)
- If you cannot create files locally in the workspace, check:
  - Correct workspace folder opened in editor (project root should contain `package.json`).
  - File system permissions for the folder (on Windows, check Explorer properties or run editor as the same user).
  - Git or external sync tools locking files (close other processes or check `git status`).
- Quick verification (run from project root):

```bash
# list files and show new copilot instructions file
ls -la .github || true
cat .github/copilot-instructions.md
npm run dev
```

If anything created by the AI appears missing after writing, refresh your editor file explorer or reopen the folder.

If you want me to expand or merge content from an existing `.github/copilot-instructions.md` or other agent docs, point me at the file and I'll merge preserving valuable lines.

Thanks — ask for clarifications or to add project-specific helper scripts or PR templates.