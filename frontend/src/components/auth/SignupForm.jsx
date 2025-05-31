import Button from "@/components/common/button/Button";

function SignupForm() {
    return (
        <form>
            <input type="email" placeholder="이메일" />
            <input type="password" placeholder="비밀번호" />
            <Button type="submit">가입하기</Button>
        </form>
    );
}

export default SignupForm;
