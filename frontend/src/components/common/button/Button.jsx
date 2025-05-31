import styles from "./Button.module.css";

function Button({ type = "button", children, variant = "primary", ...props }) {
    return (
        <button
            type={type}
            className={`${styles.btn} ${styles[`btn-${variant}`]}`}
            {...props}
        >
            {children}
        </button>
    );
}

export default Button;
