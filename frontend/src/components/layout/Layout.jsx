import Footer from "@/components/footer/Footer";
import Header from "@/components/header/Header";
import { Outlet } from "react-router-dom";
import styles from "./Layout.module.css";

function Layout() {
    return (
        <div className={styles.wrapper}>
            <Header />
            <main className={styles.content}>
                <Outlet />
            </main>
            <Footer />
        </div>
    );
}
export default Layout;
