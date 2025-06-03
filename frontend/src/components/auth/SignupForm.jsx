import Button from "@/components/common/button/Button";
import Input from "@/components/common/input/Input";
import { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import "./SignupForm.css";

function SignupForm({ formData, handleFormDataChange, handleVerifyEmail }) {
    const [birth, setBirth] = useState(null);

    return (
        <form className="signup-form">
            <div className="signup-form__field">
                <div className="input-with-button">
                    <Input
                        type="email"
                        name="email"
                        value={formData.email}
                        placeholder="이메일"
                        onChange={handleFormDataChange}
                    />
                    <Button type="button" onClick={handleVerifyEmail}>
                        인증 요청
                    </Button>
                </div>
                <Input type="password" name="password" placeholder="비밀번호" />
                <Input type="text" name="nickname" placeholder="닉네임" />
                <Input
                    type="text"
                    name="phoneNumber"
                    placeholder="010-0000-0000"
                />
                <Input type="text" name="address" placeholder="주소" />
                <DatePicker
                    selected={birth}
                    onChange={(date) => setBirth(date)}
                    customInput={<Input placeholder="생년월일" name="birth" />}
                    dateFormat="yyyy-MM-dd"
                    maxDate={new Date()}
                    showYearDropdown
                    scrollableYearDropdown
                    yearDropdownItemNumber={100}
                />
                <Input type="text" name="gender" placeholder="성별 (M/F)" />
            </div>
            <div className="signup-form__button-group">
                <Button type="submit">가입</Button>
                <Button type="button">취소</Button>
            </div>
        </form>
    );
}

export default SignupForm;
