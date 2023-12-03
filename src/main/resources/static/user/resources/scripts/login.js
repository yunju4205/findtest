const check = window.document.getElementById("check");
const button = window.document.getElementById("form");
const input = {
    email: window.document.querySelector('input[type="email"]'),
    password: window.document.querySelector('input[type="password"]'),
};

button.addEventListener('submit', (e) => {
    if (input.email.value === "" && input.password.value === "") {
        check.innerText = "이메일을 입력해주세요";
        check.style.color = "red";
        e.preventDefault();
        return;
    }

    if (input.password.value === "") {
        check.innerText = "비밀번호를 입력해주세요";
        check.style.color = "red";
        e.preventDefault();
        return;
    }

    if (input.email.value === "") {
        check.innerText = "이메일을 입력해주세요";
        check.style.color = "red";
        e.preventDefault();
        return;
    }
});
