import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// keeping the port at 3000 like day 26, handout always assumes localhost:3000
export default defineConfig({
  plugins: [react()],
  server: {
    port: 3000,
  },
})
