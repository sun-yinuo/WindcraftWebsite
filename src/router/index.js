import { createRouter, createWebHashHistory} from 'vue-router'
import Course from '/src/components/Course/Course'
const router = createRouter({
    history: createWebHashHistory(),
    routes:[
        {
            path: "/course",
            component: Course,
        }
    ],
})

export default router

