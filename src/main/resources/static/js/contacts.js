console.log("contacts.js");

const baseURL = "http://localhost:8081";


// view contact
const viewContactModal = document.getElementById("view_contact_modal");

// options with default values
const options = {
  placement: "bottom-right",
  backdrop: "dynamic",
  backdropClasses: "bg-gray-900/50 dark:bg-gray-900/80 fixed inset-0 z-40",
  closable: true,

  onHide: () => {
    console.log("modal is hidden");
  },
  onShow: () => {
    console.log("modal is shown");
  },
  onToggle: () => {
    console.log("modal has been toggled");
  },
};

// instance options object
const instanceOptions = {
  id: "view_contact_modal",
  override: true,
};

const contactModal = new Modal(viewContactModal, options, instanceOptions);

function openContactModal() {
  contactModal.show();
}

function closeContactModal() {
  contactModal.hide();
}

async function loadContactData(id) {
  // funtion call to load data
  try {
    console.log(id);
    const response = await fetch(`${baseURL}/api/contacts/${id}`);

    const data = await response.json();
    console.log(data);

    document.querySelector("#contact_name").innerHTML = data.name;
    document.querySelector("#contact_email").innerHTML = data.email;
    document.querySelector("#contact_image").src = data.picture;
    document.querySelector("#contact_address").innerHTML = data.address;
    document.querySelector("#contact_phone").innerHTML = data.phoneNumber;
    document.querySelector("#contact_about").innerHTML = data.description;
    const contactFavourite = document.querySelector("#contact_favourite");
    if (data.favourite) {
      contactFavourite.innerHTML =
        "<span><i class='fas fa-star text-yellow-400'></i>Favourite</span>";
    } else {
      contactFavourite.innerHTML = "Not Favourite";
    }

    document.querySelector("#contact_website").href = data.websiteLink;
    document.querySelector("#contact_website").innerHTML = data.websiteLink;
    document.querySelector("#contact_linkedIn").href = data.linkedInLink;
    document.querySelector("#contact_linkedIn").innerHTML = data.linkedInLink;
    openContactModal();

    return data;
  } catch (err) {
    console.log(err);
  }
}


// delete contact
async function deleteContact(id){
  Swal.fire({
  title: "Do you want to delete this contact?",
  icon: "warning",
  showCancelButton: true,
  confirmButtonText: "Delete",
}).then((result) => {
  /* Read more about isConfirmed, isDenied below */
  if (result.isConfirmed) {

    const url = `${baseURL}/user/contacts/delete/` + id;
    window.location.replace(url);

    Swal.fire("Deleted Successfully!", "", "success");
  }
});
}
