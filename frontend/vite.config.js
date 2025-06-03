import react from "@vitejs/plugin-react";
import path, { dirname } from "path"; // 경로 처리 유틸
import { fileURLToPath } from "url"; // ESM에서 경로 가져오기용
import { defineConfig } from "vite";

const __filename = fileURLToPath(import.meta.url); // 현재 파일의 실제 경로
const __dirname = dirname(__filename); // 그 파일이 들어있는 폴더 경로

export default defineConfig({
    server: {
        proxy: {
            "/api": {
                target: "http://localhost:8080",
                changeOrigin: true,
            },
        },
    },
    plugins: [react()],
    resolve: {
        alias: {
            "@": path.resolve(__dirname, "src"),
        },
    },
});
