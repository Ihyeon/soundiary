import styles from "./Input.module.css";

function Input({
    type = "text",
    name,
    placeholder,
    value,
    onChange,
    className,
}) {
    return (
        <input
            className={`${styles.input} ${className || ""}`}
            type={type}
            name={name}
            placeholder={placeholder}
            value={value}
            onChange={onChange}
        />
    );
}

export default Input;
