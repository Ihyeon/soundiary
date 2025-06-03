import SignupForm from "@/components/auth/SignupForm";
import axios from "axios";
import { useState } from "react";

function Signup() {
    const [formData, setFormData] = useState({
        email: "",
        nickname: "",
        phone: "",
    });

    const handleFormDataChange = (e) => {
        const { name, value } = e.target;
        setFormData((prev) => ({ ...prev, [name]: value }));
        // console.log("🎵폼데이터: ", formData);
    };

    const handleVertifyEmail = async () => {
        const { email } = formData;
        console.log("✅ 이메일 값:", email);
        console.log("✅ 요청 URL:", `/api/users/check-email?email=${email}`);

        try {
            const response = await axios.get(
                `/api/users/check-email?email=${email}`
            );
            console.log("🎵이메일 중복 확인 결과: ", response.data);
        } catch (error) {
            console.log("🎵이메일 중복 확인 실패: ", error);
        }
    };

    return (
        <div className="signup-page">
            <SignupForm
                formData={formData}
                handleFormDataChange={handleFormDataChange}
                handleVerifyEmail={handleVertifyEmail}
            />
        </div>
    );
}

export default Signup;
