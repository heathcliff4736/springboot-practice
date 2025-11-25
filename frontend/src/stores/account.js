//계정 스토어 구현
//frontend/src/stores/account.js
import { defineStore } from 'pinia'

// 상태정보를 관리하는 스토어 (계정 데이터)
export const useAccountStore = defineStore('account', {
    state: () => ({
        checked: false,
        loggedIn: false,
    }),
    actions: {
        setChecked(val) {
            this.checked = val
        },
        setLoggedIn(val) {
            this.loggedIn = val
        },
    },
});
