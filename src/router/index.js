import {createRouter, createWebHashHistory} from 'vue-router'
import Course from '/src/components/course/Course'
import Ban from '/src/components/ban/Ban'
import Report from '/src/components/report/report'
import TeamCourse from '/src/components/teamCourse/teamCourse'
import UserConfig from "/src/components/userConfig/UserConfig";

const router = createRouter({
    history: createWebHashHistory(),
    routes:[
        {
            path: "/course",
            component: Course,
        },
        {
            path: "/teamCourse",
            component: TeamCourse,
        },
        {
            path: "/report",
            component: Report,
        },
        {
            path: "/ban",
            component: Ban,
        },
        {
            path: "/userConfig",
            component: UserConfig
        }
    ],
})

export default router

