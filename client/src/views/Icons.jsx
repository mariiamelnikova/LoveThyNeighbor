import React from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormHelperText from '@material-ui/core/FormHelperText';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';
import {TextareaAutosize, TextField} from "@material-ui/core";
import CustomButton from "../components/CustomButton/CustomButton";
import Button from "@material-ui/core/Button";
import Icon from '@material-ui/core/Icon';

const useStyles = makeStyles(theme => ({
    formControl: {
        margin: theme.spacing(3),
    },
}));

export default function RadioButtonsGroup() {
    const classes = useStyles();
    const [value, setValue] = React.useState('Donation Amount');

    const handleChange = event => {
        setValue(event.target.value);
    };

  const onClick = event => {
    setValue(event.target.value);
  };

    return (

        <div>
            <FormControl component="fieldset" className={classes.formControl}>
                <FormLabel component="legend">Choose Amount</FormLabel>
                <RadioGroup aria-label="gender" name="gender1" value={value} onChange={handleChange}>
                  <FormControlLabel value="small" control={<Radio/>} label="$5" fontSize="medium"/>
                  <FormControlLabel value="small" control={<Radio/>} label="$35"/>
                    <FormControlLabel paddingBottom="0" value="large" control={<Radio/>} label="$75"/>
                    <TextField
                        id="standard-basic"
                        label="Custom Amount"
                    />
                    <Button
                        variant="contained"
                        color="primary"
                    > Donate </Button>

                </RadioGroup>
            </FormControl>
        </div>
    );
}
