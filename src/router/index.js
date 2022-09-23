import {createRouter, createWebHashHistory} from 'vue-router'
import Course from '/src/components/course/Course'
import Ban from '/src/components/ban/Ban'
import Report from '/src/components/report/report'

const router = createRouter({
    history: createWebHashHistory(),
    routes:[
        {
            path: "/course",
            component: Course,
        },
        {
            path: "/ban",
            component: Ban,
        },{
            path: "/report",
            component: Report,
        }
    ],
})

export default router

