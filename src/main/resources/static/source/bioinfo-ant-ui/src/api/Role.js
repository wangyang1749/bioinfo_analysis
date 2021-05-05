import service from '@/utils/service'
const baseUrl = '/api/role'

const UserApi = {}

UserApi.page = (params) =>{
    return service({
        url: `${baseUrl}`,
        params: params,
        method: 'get'
    })
}



export default UserApi