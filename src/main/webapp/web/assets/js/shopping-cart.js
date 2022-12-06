window.addEventListener('load', () => {
    // Handle change line total when change line quantity
    let lineQuantityInputs = document.querySelectorAll('input.line-quantity');
    if (lineQuantityInputs != null) {
        lineQuantityInputs.forEach((input) => {
            let trEle = input.closest('tr');
            input.addEventListener('change', () => {
                let quantity = Number(input.value)
                let price = Number(trEle.dataset.price)
                let discount = Number(trEle.dataset.discount)
                trEle.setAttribute('data-quantity', quantity.toString())
                trEle.querySelector('.cart__price').innerHTML = (discount === 0 ? price * quantity : discount * quantity) + ' đ'
                calcCartTotal()
            })
        })
    }

    // Calc cart total when click in checkbox
    let lineCheckboxs = document.querySelectorAll('input.line-choose')
    if (lineCheckboxs != null) {
        lineCheckboxs.forEach((checkbox) => {
            checkbox.addEventListener('change', () => {
                calcCartTotal()
            })
        })
    }
    const calcCartTotal = () => {
        const provisionalElm = document.querySelector('#provisional span')
        const discountElm = document.querySelector('#discount span')
        const totalElm = document.querySelector('#total span')

        let provisional = 0
        let discount = 0
        let total

        lineCheckboxs.forEach((checkbox) => {
            if (checkbox.checked) {
                let trElm = checkbox.closest('tr')
                provisional += Number(trElm.dataset.price) * Number(trElm.dataset.quantity)
                discount += (Number(trElm.dataset.discount) !== 0 ? Number(trElm.dataset.price) - Number(trElm.dataset.discount) : 0) * Number(trElm.dataset.quantity)
            }
        })
        total = provisional - discount

        provisionalElm.innerText = provisional + ' đ'
        discountElm.innerText = -discount + ' đ'
        totalElm.innerText = total + ' đ'
    }

    // Checkout
    const checkoutForm = document.getElementById('checkout')
    const submitBtn = checkoutForm.querySelector('input[type="submit"]')
    submitBtn.addEventListener('click', (ev) => {
        ev.preventDefault()
        let cartItems = []
        lineCheckboxs.forEach((checkbox) => {
            if (checkbox.checked) {
                let trElm = checkbox.closest('tr')
                cartItems.push({
                    cartItemId: trElm.dataset.cartitemId,
                    productId: trElm.dataset.productId,
                    quantity: trElm.dataset.quantity,
                })
            }
        })
        if (cartItems.length) {
            cartItems.forEach((item) => {
                let inputHtml = `<input type="hidden" name="data" value="${item.cartItemId}|${item.productId}|${item.quantity}">`
                checkoutForm.innerHTML += inputHtml;
            })
            checkoutForm.submit()
        } else {
            alert("There must be at least one product selected in your cart")
        }
    })
})