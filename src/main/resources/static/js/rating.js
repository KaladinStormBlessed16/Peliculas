const GeneralContainer = document.querySelector(".GeneralStars");
const GeneralStars = GeneralContainer.querySelectorAll(".star");
const GeneralInputs = GeneralContainer.querySelectorAll(".starInput");

GeneralContainer.onclick = e =>{
	const eClass = e.target.classList;
	if(!eClass.contains("active")){
		GeneralStars.forEach(star => star.classList.remove("active"));
		eClass.add("active");
		const value = 5 - e.target.getAttribute("id");
		GeneralInputs[value].checked=true;
	}
};
