import service from '@/utils/service'
const baseUrl = '/api/user'

const UserApi = {}

UserApi.page = (params) =>{
    return service({
        url: `${baseUrl}`,
        params: params,
        method: 'get'
    })
}

UserApi.login = (data)=>{
    return service({
        url:`${baseUrl}/login`,
        data:data,
        method: 'post'
    })
}

export default UserApi
