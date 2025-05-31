import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import { RecoilRoot } from "recoil";
import App from "./App.jsx";

import "./styles/index.css"; // 전역 스타일

createRoot(document.getElementById("root")).render(
    <StrictMode>
        <RecoilRoot>
            <BrowserRouter>
                <App />
            </BrowserRouter>
        </RecoilRoot>
    </StrictMode>
);
