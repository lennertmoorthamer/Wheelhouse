import axiosDependency from 'axios';

//Fetch from .env file
const ApiUrl = "http://localhost:1000/";
const timeout = parseInt(5000);

/**
 * Takes a string, replaces all \ with / and ensures it starts with a /
 *
 * @param {String} url a cleaned up URL
 */
function cleanUrl(url) {
  if (typeof url !== 'string') {
    url = url.toString();
  }

  let cleanBase = url.replaceAll('\\', '/');

  if (!url.startsWith('/')) {
    cleanBase = '/' + cleanBase;
  }

  return cleanBase;
}

/**
 * A function that contains the default request config to use for axios
 * see https://github.com/Axios/Axios#request-config
 * @returns an array with the default request config to use for axios
 */
function getBasicRequestParams() {
  return {
    baseURL: ApiUrl,
    timeout: timeout,
    maxContentLength: -1,
    maxBodyLength: -1,
    responseType: 'application/json',
    responseEncoding: 'utf8',
    maxRedirects: 10
  };
}

export default class axiosImp {
  static async get(url) {
    return await axiosDependency.get(cleanUrl(url), getBasicRequestParams());
  }
}