import { createRouter, createWebHashHistory} from 'vue-router'
import Course from '/src/components/Course/Course'
import Ban from '/src/components/Ban/Ban'
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
        }
    ],
})

export default router

