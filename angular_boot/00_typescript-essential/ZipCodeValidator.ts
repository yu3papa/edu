import {StringValidator} from "./Validation";
/**
 * Created by vega on 2017-05-29.
 */
export const numberRegexp = /^[0-9]+$/;

export class ZipCodeValidator implements StringValidator {
    isAcceptable(s: string) {
        return s.length === 5 && numberRegexp.test(s);
    }
}