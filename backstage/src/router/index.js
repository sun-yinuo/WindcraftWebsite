import {createRouter, createWebHashHistory} from 'vue-router'
import ReportMassage from "@/components/reportMassage/ReportMassage";

const router = createRouter({
    history: createWebHashHistory(),
    routes:[
        {
            path: "/reportMassage",
            component : ReportMassage,
        }

    ],
})

export default router

