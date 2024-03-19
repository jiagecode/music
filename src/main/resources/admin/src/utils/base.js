const base = {
    get() {
        return {
            url : "http://localhost:8080/springbooth44gn/",
            name: "springbooth44gn",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbooth44gn/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot的在线音乐网站"
        } 
    }
}
export default base
