import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// vite defaults to port 5173, handout expects localhost:3000 so matching that instead
export default defineConfig({
  plugins: [react()],
  server: {
    port: 3000,
  },
})
